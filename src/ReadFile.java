import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadFile {
    
    ArrayList<String> names = new ArrayList<String>();
    HashMap<String, String> fList = new HashMap<String, String>();

    String line;
    String[] values;
    int select;
    int[] stats;


    public boolean readFromList() throws Exception{ // catches exceptions

        try {
            readPets("SavedPets.txt");
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Pet file not found");
            return false;
        }
    }



    public void readPets(String fname) throws Exception { // reads file to write to arrays

        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);

        while ((line = br.readLine()) != null) {
            values = line.split(", ");
            addToArray(values);
            
        }

        br.close();

    }

    public void addToArray(String[] values) { // add values type of animal, status from arrays to Collections
        names.add(values[0]);
        fList.put(values[0], values[1]);
    }
    
}
