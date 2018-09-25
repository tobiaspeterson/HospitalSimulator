import java.util.ArrayList;
import java.util.Arrays;

public class ScheduleConsultations {

    private ArrayList<ArrayList<Doctor>> availableDoctors = new ArrayList<ArrayList<Doctor>>();
    private ArrayList<ArrayList<TreatmentRoom>> availableRooms = new ArrayList<ArrayList<TreatmentRoom>>();

    private ArrayList<Doctor> doctorsCurrentConsultationDay = new ArrayList<Doctor>();
    private ArrayList<TreatmentRoom> roomsCurrentConsultationDay = new ArrayList<TreatmentRoom>();

    private ArrayList<Doctor> allDoctors = new ArrayList<Doctor>();
    private ArrayList<TreatmentRoom> allRooms = new ArrayList<TreatmentRoom>();

    private ArrayList<Consultation> newConsultations = new ArrayList<Consultation>();
    private ArrayList<ArrayList<Consultation>> scheduledConsultations = new ArrayList<ArrayList<Consultation>>();

    public ArrayList<ArrayList<Consultation>> scheduleNewConsultations(ArrayList<ArrayList<Consultation>> existingConsultations, ArrayList<Patient> patients, int registrationDay, int consultationDay){
        scheduledConsultations = existingConsultations;
        int i = 0;

        boolean newConsultation;

        if (availableRooms.size() < consultationDay - 1){
            availableRooms.add(new ArrayList<TreatmentRoom>(allRooms));
            availableDoctors.add(new ArrayList<Doctor>(allDoctors));
        }
        else{
            newConsultations = scheduledConsultations.get(consultationDay-2);
        }

        doctorsCurrentConsultationDay = availableDoctors.get(consultationDay-2);
        roomsCurrentConsultationDay = availableRooms.get(consultationDay-2);

        ArrayList<Patient> newPatients = new ArrayList<Patient>(patients);
        while (i < newPatients.size()){
            if (newPatients.get(i).getCondition().toLowerCase().equals("flu")){
                newConsultation = fluPatient(newPatients.get(i), registrationDay, consultationDay);
            }
            else if (newPatients.get(i).getTopography().toLowerCase().equals("head & neck")){
                newConsultation = headNeckCancerPatient(newPatients.get(i), registrationDay, consultationDay);
            }
            else {
                newConsultation = breastCancerPatient(newPatients.get(i), registrationDay, consultationDay);
            }

            if (newConsultation){
                newPatients.remove(i);
            }
            else{
                i++;
            }
        }

        availableDoctors.set(consultationDay-2, new ArrayList<Doctor>(doctorsCurrentConsultationDay));
        availableRooms.set(consultationDay-2, new ArrayList<TreatmentRoom>(roomsCurrentConsultationDay));
        scheduledConsultations.add(consultationDay-2, new ArrayList<Consultation>(newConsultations));
        doctorsCurrentConsultationDay.clear();
        roomsCurrentConsultationDay.clear();
        newConsultations.clear();

        consultationDay++;

        if (newPatients.size() != 0){
            return scheduleNewConsultations(scheduledConsultations, newPatients, registrationDay, consultationDay);
        }
        else {
            return scheduledConsultations;
        }
    }

    private boolean fluPatient(Patient patient, int registrationDay, int consultationDay){
        int doctorIndex = 0;
        boolean consultationCreated = false;
        while ( doctorIndex < doctorsCurrentConsultationDay.size()){
            if (Arrays.asList(doctorsCurrentConsultationDay.get(doctorIndex).getRoles()).contains("GeneralPractitioner")){
                newConsultations.add(new Consultation(patient,roomsCurrentConsultationDay.get(0), doctorsCurrentConsultationDay.get(doctorIndex), registrationDay, consultationDay));
                doctorsCurrentConsultationDay.remove(doctorIndex);
                roomsCurrentConsultationDay.remove(0);
                doctorIndex = doctorsCurrentConsultationDay.size();
                consultationCreated = true;
            }
            else {
                doctorIndex++;
            }
        }
        return consultationCreated;
    }

    private boolean headNeckCancerPatient(Patient patient, int registrationDay, int consultationDay){
        int doctorIndex = 0;
        boolean consultationCreated = false;
        while ( doctorIndex < doctorsCurrentConsultationDay.size()){
            if (Arrays.asList(doctorsCurrentConsultationDay.get(doctorIndex).getRoles()).contains("Oncologist")){
                int roomIndex = 0;
                while (roomIndex < roomsCurrentConsultationDay.size()){
                    if (roomsCurrentConsultationDay.get(roomIndex).getCapability().equals("Advanced")){
                        newConsultations.add(new Consultation(patient,roomsCurrentConsultationDay.get(roomIndex), doctorsCurrentConsultationDay.get(doctorIndex), registrationDay, consultationDay));
                        doctorsCurrentConsultationDay.remove(doctorIndex);
                        roomsCurrentConsultationDay.remove(roomIndex);
                        roomIndex = roomsCurrentConsultationDay.size();
                        doctorIndex = doctorsCurrentConsultationDay.size();
                        consultationCreated = true;
                    }
                    else{
                        roomIndex++;
                    }
                }
            }
            doctorIndex++;
        }
        return consultationCreated;
    }

    private boolean breastCancerPatient (Patient patient, int registrationDay, int consultationDay){
        int doctorIndex = 0;
        boolean consultationCreated = false;
        while ( doctorIndex < doctorsCurrentConsultationDay.size()){
            if (Arrays.asList(doctorsCurrentConsultationDay.get(doctorIndex).getRoles()).contains("Oncologist")){
                int roomIndex = 0;
                while (roomIndex < roomsCurrentConsultationDay.size()){
                    if (roomsCurrentConsultationDay.get(roomIndex).getTreatmentmachine() != null){
                        newConsultations.add(new Consultation(patient,roomsCurrentConsultationDay.get(roomIndex), doctorsCurrentConsultationDay.get(doctorIndex), registrationDay, consultationDay));
                        doctorsCurrentConsultationDay.remove(doctorIndex);
                        roomsCurrentConsultationDay.remove(roomIndex);
                        roomIndex = roomsCurrentConsultationDay.size();
                        doctorIndex = doctorsCurrentConsultationDay.size();
                        consultationCreated = true;
                    }
                    else{
                        roomIndex++;
                    }
                }
            }
            doctorIndex++;
        }
        return consultationCreated;
    }

    public void setDoctors(ArrayList<Doctor> doctors){
        allDoctors = doctors;
    }

    public void setTreatmentRooms(ArrayList<TreatmentRoom> treatmentRooms){
        allRooms = treatmentRooms;
    }
}
