import java.util.InputMismatchException;
import java.util.Scanner;

public class NewPet extends GeneratePet { // Class to create a new pet from user input

    Scanner sc = new Scanner(System.in);
    boolean valid = false;

    

    public NewPet() {
        
    }

    // new method for gui, creates a pet object
    public Animal newPet(int type, String name) {

        if (name.equals("")) {

            return null;

        } 

        if (type == 0) {

            return null;

        } 

        return generatePet(type, name);
    }


}
