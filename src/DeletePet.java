
public class DeletePet {

    MainMenu mm;

    public DeletePet(MainMenu mm) {
        this.mm = mm;
    }
    // calls db delete, then sets Pet to null
    public void delete(String oname, String pname) {
        DBIO io = new DBIO();
        io.delete(oname, pname);
        mm.setpet(null);

    }

}
