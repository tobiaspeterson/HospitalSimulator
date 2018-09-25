public class Consultation {
    private Patient patient;
    private TreatmentRoom treatmentRoom;
    private Doctor doctor;
    private int registrationDay;
    private int consultationDay;

    Consultation(Patient patient, TreatmentRoom treatmentRoom, Doctor doctor, int registrationDay, int consultationDay){
        this.patient = patient;
        this.treatmentRoom = treatmentRoom;
        this.doctor = doctor;
        this.registrationDay = registrationDay;
        this.consultationDay = consultationDay;
    }

    public Patient getPatient() {
        return patient;
    }

    public TreatmentRoom getTreatmentRoom() {
        return treatmentRoom;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public int getRegistrationDay() {
        return registrationDay;
    }

    public int getConsultationDay() {
        return consultationDay;
    }
}
