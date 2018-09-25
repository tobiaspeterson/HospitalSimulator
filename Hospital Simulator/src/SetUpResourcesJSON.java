import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SetUpResourcesJSON {
    String folder = "C:\\javascripts_intellij\\Hospital Simulator\\";
    public ArrayList<Doctor> readJsonFileDoctors() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
        try {
            doctors = mapper.readValue(new FileInputStream(folder + "Doctors.json"), new TypeReference<ArrayList<Doctor>>(){});
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public ArrayList<TreatmentMachine> readJsonFileTreatmentMachines(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ArrayList<TreatmentMachine> treatmentMachines = new ArrayList<TreatmentMachine>();
        try {
            treatmentMachines = mapper.readValue(new FileInputStream(folder + "Treatmentmachines.json"), new TypeReference<ArrayList<TreatmentMachine>>(){});
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return treatmentMachines;
    }

    public ArrayList<TreatmentRoom> readJsonFileTreatmentRooms(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ArrayList<TreatmentRoom> treatmentRooms = new ArrayList<TreatmentRoom>();
        try {
            treatmentRooms = mapper.readValue(new FileInputStream(folder + "Treatmentrooms.json"), new TypeReference<ArrayList<TreatmentRoom>>(){});
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return treatmentRooms;
    }

    public ArrayList<TreatmentRoom> addMachineCapabilityToRoom(ArrayList<TreatmentRoom> rooms, ArrayList<TreatmentMachine> machines){
        for (int i = 0; i < rooms.size(); i++){
            if (rooms.get(i).getTreatmentmachine() != null){
                for (int a = 0; a < machines.size(); a++){
                    if (rooms.get(i).getTreatmentmachine().equals(machines.get(a).getName())){
                        rooms.get(i).setCapability(machines.get(a).getCapability());
                    }
                }
            }
        }
        return rooms;
    }
}
