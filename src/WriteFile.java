import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class WriteFile {

    public void writeToFile(ArrayList<String> names, HashMap<String, String> fList) throws Exception{

        FileOutputStream fos = new FileOutputStream("SavedPets.txt");
        PrintWriter pw = new PrintWriter(fos);


        for (int i = 0; i < names.size(); i++) {
            
            pw.println(names.get(i) + ", " + fList.get(names.get(i))); // writes (name, classtype status) on each line to the file
            
        }

        pw.close();


    }
    

}
