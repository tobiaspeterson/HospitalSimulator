public class TreatmentRoom {
    private String name;
    private String treatmentMachine;
    private String capability = "";

    TreatmentRoom(){};
    TreatmentRoom(String name, String treatmentMachine){
        this.name = name;
        this.treatmentMachine = treatmentMachine;
    }

    public String getName() {
        return this.name;
    }

    public String getTreatmentmachine(){
        return this.treatmentMachine;
    }

    public String getCapability() {
        return capability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTreatmentMachine(String treatmentMachine) {
        this.treatmentMachine = treatmentMachine;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

}
