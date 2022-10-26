import java.util.Scanner;

public class DeletePet {
    
    public boolean deleteFromFile(Animal input) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Are you sure you want to delete " + input.getName() + "? :(");
        System.out.print("Type " + input.getName() + "'s name to confirm:");

        if (!sc.nextLine().equals(input.getName())) {
            System.out.println("Deletion aborted");
            return false;
        }

        ReadFile rf = new ReadFile();
        WriteFile wf = new WriteFile();

        if (!rf.readFromList()) {
            return false;
        }
        rf.names.remove(input.getName());
        rf.fList.put(input.getName(), "");

        wf.writeToFile(rf.names, rf.fList);

        System.out.println(input.getName() + " has been deleted.");

        return true;

    }
}
