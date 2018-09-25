public class Patient {
    private String name;
    private String condition;
    private String topography;

    Patient (){};
    Patient (String name, String condition, String topography){
        this.name = name;
        this.condition = condition;
        this.topography = topography;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public String getTopography() {
        return topography;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setTopography(String topography) {
        this.topography = topography;
    }
}
