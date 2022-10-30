
import java.util.ArrayList;

public class SavePet {

    public void save(Animal input, String oname) {
        DBIO io = new DBIO();
        ArrayList<String> nlist = new ArrayList<String>();
        nlist = io.getnameList(oname);

        // if pet name already exists
        if (nlist.contains(input.getName())) {

            io.updatemood(oname, input.getName(), input.getStatus()); // update its mood

        } else {
            int type = classType(input);
            io.newsave(oname, input.getName(), type, input.getStatus()); // else make a new entry to the db
        }

    }

    // get classtype
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
