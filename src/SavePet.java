
import java.util.ArrayList;


public class SavePet {

    public void save(Animal input, String oname) { //implement arraylist.contains()
        DBIO io = new DBIO();
        ArrayList<String> nlist = new ArrayList<>();
        nlist = io.getnameList(oname);
        

        if (nlist.contains(input.getName())) {

            io.updatemood(oname, input.getName(), input.getStatus());

        } else {
            int type = classType(input);
            io.newsave(oname, input.getName(), type, input.getStatus());
        }

    }

    public void saveToFile(Animal input) throws Exception {

        ReadFile rf = new ReadFile();
        WriteFile wf = new WriteFile();

        if (!rf.readFromList()) {
            return;
        }

        String name = input.getName();
        if (!rf.names.contains(input.getName())) {

            rf.names.add(name);

        }

        //rf.values = rf.fList.get(name).split(" "); 
        int type = classType(input);

        String value = type + " " + input.getStatus();
        rf.fList.put(name, value);
        wf.writeToFile(rf.names, rf.fList);

        System.out.println(input.getName() + " has been saved");

    }

    public int classType(Animal input) {
        int type;
        String nameoftype = input.getClass().toString();

        switch (nameoftype) {
            case "class Dog":
                type = 1;
                break;

            case "class Cat":
                type = 2;
                break;

            default:
                type = 1;
                break;

        }
        return type;
    }

}
