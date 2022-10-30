
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

}
