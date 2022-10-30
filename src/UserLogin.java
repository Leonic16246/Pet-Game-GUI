
import java.sql.SQLException;

/**
 *
 * @author Leon
 */
public class UserLogin {

    DBIO io;
    MainMenu mm;

    public UserLogin(MainMenu mainmenu) {
        this.io = new DBIO();
        this.mm = mainmenu;
        //rset = io.getutable();
    }

    public boolean login(String uname) {

        if (uname.equals("")) {
            return false;
        }

        io.setrset(null);
        try {
            io.setrset(io.getutable());

            while (io.getrset().next()) {
                if (uname.equals(io.getrset().getString("uname"))) { // if username exists in database, do nothing
                    mm.setuname(uname);
                    return true;
                }
            }
            // else insert username into db
            io.setpstate("INSERT INTO UTABLE (UNAME) VALUES(?)");

            io.getpstate().setString(1, uname);
            io.getpstate().executeUpdate();

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
        mm.setuname(uname);
        return true;
    }
}
