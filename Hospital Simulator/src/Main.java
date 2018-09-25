import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Consultation>> existingConsultations = new ArrayList<ArrayList<Consultation>>();

        SetUpResourcesJSON setResources = new SetUpResourcesJSON();

        ScheduleConsultations scheduler = new ScheduleConsultations();

        ArrayList<Doctor> doctors = setResources.readJsonFileDoctors();
        scheduler.setDoctors(doctors);

        ArrayList<TreatmentMachine> treatmentMachines = setResources.readJsonFileTreatmentMachines();

        ArrayList<TreatmentRoom> treatmentRooms = setResources.readJsonFileTreatmentRooms();
        treatmentRooms = setResources.addMachineCapabilityToRoom(treatmentRooms, treatmentMachines);
        scheduler.setTreatmentRooms(treatmentRooms);

        ReadNewPatients readPatients = new ReadNewPatients();
        ArrayList<ArrayList<Patient>> patients = new ArrayList<ArrayList<Patient>>();

        String keepGoing = "Y";
        int registrationDay = 0;
        while (keepGoing.toUpperCase().equals("Y")) {
            registrationDay++;
            patients.add(readPatients.readJsonFilePatients());
            existingConsultations = scheduler.scheduleNewConsultations(existingConsultations, patients.get(registrationDay-1), registrationDay, registrationDay+1);
            System.out.printf("%nEnter YES to print the booked consultations this far, all of them will be printed regardless when the run is done:%n");
            Scanner scanner = new Scanner(System.in);
            if (scanner.nextLine().trim().toUpperCase().equals("YES")){
                Printer additionalPrint = new Printer();
                additionalPrint.printConsultations(existingConsultations);
            }

            System.out.printf("%nEnter Y to start a new day where you can enter new patients or enter anything else to stop:%n");
            Scanner scan = new Scanner(System.in);
            keepGoing = scan.nextLine().trim();
        }
        Printer printer = new Printer();
        printer.printConsultations(existingConsultations);
        printer.printRegisteredPatients(patients);
    }
}
