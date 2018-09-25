public class Doctor {
    private String Name;
    private String[] Roles;

    Doctor (){};
    Doctor (String Name, String[] Roles){
        this.Name = Name;
        this.Roles = Roles;
    }

    public String getName() {
        return this.Name;
    }

    public String[] getRoles() {
        return this.Roles;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setRoles(String[] Roles) {
        this.Roles = Roles;
    }
}
