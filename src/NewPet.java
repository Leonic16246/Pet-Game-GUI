import java.util.InputMismatchException;
import java.util.Scanner;

public class NewPet extends GeneratePet { // Class to create a new pet from user input

    Scanner sc = new Scanner(System.in);
    boolean valid = false;

    

    public NewPet() {
        
    }


    public Animal newPet() {

        NewPet npet = new NewPet();

        int type = npet.petType();

        if (type == 0) {

            return null;

        } 


        String name = npet.petName();

        if (name.equals("0")) {

            return null;

        } 
        
        System.out.println(name + " has been adopted!");
        return generatePet(type, name);

    }

    public Animal newPet(int type, String name) {

        if (name.equals("Enter pet name here")) {

            return null;

        } 

        if (type == 0) {

            return null;

        } 

        return generatePet(type, name);
    }

    public int petType() {

        int type = 0;
        while (!valid) {
            try {
                System.out.println("What type of pet would you like adopt?");
                System.out.print("1. Dog, 2. Cat, 0. To exit: ");
                type = sc.nextInt();
                if (type >= 0 && type < 3) {
                    valid = true;
                    break;
                }
                System.out.println("Invalid input, enter a valid number");

            } catch (InputMismatchException e) {
                System.out.println("Invalid input, enter a number");
                sc.next();
            }
        }

        return type;
    }

    public String petName() {

        sc.nextLine();
        System.out.print("What name would you like it to have? (0 to exit): ");
        String pname = sc.nextLine();

        return pname;

    }
}
