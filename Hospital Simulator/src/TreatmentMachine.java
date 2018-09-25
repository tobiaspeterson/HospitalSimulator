public class TreatmentMachine {
    private String name;
    private String capability;

    TreatmentMachine(){};
    TreatmentMachine (String name, String capability){
        this.name = name;
        this.capability = capability;
    }

    public String getName() {
        return name;
    }

    public String getCapability() {
        return capability;
    }
}
