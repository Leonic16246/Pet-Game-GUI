import java.util.InputMismatchException;
import java.util.Scanner;

public class PlaywithPet {
    
    public PlaywithPet() {
        
    }
    
    public void playwith(Animal Pet) {
        if (Pet != null) {
            Pet.Play();
            //Pet.Mood();
            } else {
            System.out.println("No pet loaded");
        }
        
    }
    
    public Animal petMenu(Animal Pet) throws Exception {

        Scanner sc = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {

            int menu = 0;
            boolean valid = false;

            while (!valid) { // check if input is an int
                try {
                    System.out.println(Pet.getName() + " is ready to play (Current status is: " + Pet.getStatus() + ")");
                    System.out.print("Press 1. to play with " + Pet.getName() + ", 2. to save current pet, 3. to load another pet, 9. to delete pet, 0. to exit to main menu: ");
                    menu = sc.nextInt();
                    valid = true;
                
                } catch (InputMismatchException e) {
                    System.out.println("Enter a number");
                    sc.next();
                    
                }
            }
    
            switch (menu) {
                case 1: // interact with pet
                    if (Pet != null) {
                        Pet.Play();
                        Pet.Mood();
                    } else {
                        System.out.println("No pet loaded");
                    }

                    break;

                case 2: // saves pet to file
                    SavePet sp = new SavePet();
                    sp.saveToFile(Pet);
                    break;

                case 3: // loads another pet from file to play with
                    //LoadPet lp = new LoadPet();
                    //Pet = lp.loadPet();
                    break;

                
                case 9: // asks user to confirm deletion, if executed, returns user to main menu
                    //DeletePet dp = new DeletePet();
//                    if (dp.deleteFromFile(Pet)) {
//                        Pet = null;
//                        exit = true;
//                    }

                    break;

                
                case 0: // quit to main menu
                    exit = true;
                    break;
            
                default: // checks if int is valid
                    System.out.println("Enter a valid number");
                    break;
            }
        }

        return Pet; // returns pet to main menu

    }
}
