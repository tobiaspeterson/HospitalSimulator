import java.util.ArrayList;

public class Printer {
    public void printConsultations(ArrayList<ArrayList<Consultation>> consultations){
        System.out.printf("%nThe scheduled consultations are the following: %n");
        for ( int i = 0; i < consultations.size(); i++){
            for (int a = 0; a < consultations.get(i).size(); a++){
                System.out.printf("%nPatient name: " + consultations.get(i).get(a).getPatient().getName() + ". Doctor: " +
                        consultations.get(i).get(a).getDoctor().getName() + ". In " + consultations.get(i).get(a).getTreatmentRoom().getName()
                        + ". Registered on day " + consultations.get(i).get(a).getRegistrationDay() + ". Consultation day: "+ consultations.get(i).get(a).getConsultationDay());
            }
        }
    }

    public void printRegisteredPatients(ArrayList<ArrayList<Patient>> patients){
        System.out.printf("%n%nPatients:");
        for (int i = 0; i < patients.size(); i++){
            System.out.printf("%nRegistered on day " + (i+1));
            for (int a = 0; a < patients.get(i).size(); a++){
                System.out.printf("%nName: " + patients.get(i).get(a).getName() + ". Condition: " + patients.get(i).get(a).getCondition());
                if (patients.get(i).get(a).getCondition().toLowerCase().equals("cancer")){
                    System.out.printf(". Topography: " + patients.get(i).get(a).getTopography());
                }
            }
        }
    }
}
