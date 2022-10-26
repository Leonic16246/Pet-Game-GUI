import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoadPet extends GeneratePet{

    Scanner sc = new Scanner(System.in);

    int select;
    ReadFile rf;
    ArrayList<String> namelist;

    

    public LoadPet() {
        this.rf = new ReadFile();
        this.namelist = rf.names;

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
