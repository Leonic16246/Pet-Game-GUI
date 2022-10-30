
import java.util.ArrayList;

public class LoadPet extends GeneratePet {

    DBIO io;

    ArrayList<String> namelist;
    ArrayList<Integer> typelist, moodlist;

    public LoadPet() {

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

}
