import java.util.Scanner;

public class DeletePet {
    
    MainMenu mm;
    
    public DeletePet(MainMenu mm) {
        this.mm = mm;
    }
    
    public void delete(String oname, String pname) {
        DBIO io = new DBIO();
        io.delete(oname, pname);
        mm.Pet = null;
        
    }
    
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
