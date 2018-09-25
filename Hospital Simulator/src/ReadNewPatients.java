import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadNewPatients {
    String folder = "C:\\javascripts_intellij\\Hospital Simulator\\";
    public ArrayList<Patient> readJsonFilePatients() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        ArrayList<Patient> patients = new ArrayList<Patient>();

        System.out.printf("%nEnter file name of JSON file with new patients to register without the .json:%n");
        Scanner scanFileName = new Scanner(System.in);
        String fileName = scanFileName.nextLine().trim();
        try {
            patients = mapper.readValue(new FileInputStream(folder + fileName + ".json"), new TypeReference<ArrayList<Patient>>(){});
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
