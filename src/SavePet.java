
import java.util.ArrayList;

public class SavePet {

    public void save(Animal input, String oname) { //implement arraylist.contains()
        DBIO io = new DBIO();
        ArrayList<String> nlist = new ArrayList<String>();
        nlist = io.getnameList(oname);

        if (nlist.contains(input.getName())) {

            io.updatemood(oname, input.getName(), input.getStatus());

        } else {
            int type = classType(input);
            io.newsave(oname, input.getName(), type, input.getStatus());
        }

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
