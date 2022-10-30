import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoadPet extends GeneratePet{

    Scanner sc = new Scanner(System.in);

    int select;
    ReadFile rf;
    MainMenu mm;
    DBIO io;
    Animal pet;
    ArrayList<String> namelist;
    ArrayList<Integer> typelist, moodlist;
    

    public LoadPet(MainMenu mainmenu) {
        this.rf = new ReadFile();

        this.io = new DBIO();
        //this.namelist = rf.names;

    }
    
    public ArrayList<String> nameslist(String oname) {
        
        return io.getnameList(oname);
        
    }
    
    public Animal load(int index, String oname) {
        
        namelist = io.getnameList(oname);
        typelist = io.gettypeList(oname);
        moodlist = io.getmoodList(oname);
        Animal a = generatePet(typelist.get(index), namelist.get(index));

        a.setStatus(moodlist.get(index));

        return a;
    }



    public Animal loadPet() throws Exception {


        if (!rf.readFromList()) {
            return null;
        }
        namelist = rf.names;

        boolean valid = false;

        while (!valid) {
            
            System.out.println("Load a pet");
            for (int i = 1; i <= rf.names.size(); i++) {
                System.out.println(i + ". " + rf.names.get(i-1) + " ");
                
            }

            try {

                select = sc.nextInt() - 1;

                if (select < rf.names.size() && select >= 0) {
                    valid = true;
                    break;
                    
                } else {
                    System.out.println("Enter a valid number");

                }
                
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number");
                sc.next();
            }

        }

        String name = rf.names.get(select);

        rf.values = rf.fList.get(name).split(" "); // Gets values from flist and splits them up into an array

        Animal a = generatePet(Integer.parseInt(rf.values[0]), name);

        a.setStatus(Integer.parseInt(rf.values[1]));

        return a;

    }




    
}
