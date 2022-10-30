
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

        io.rset = null;
        try {
            //String query = "select pin from utable where uname='" + uname + "'"; 
            io.rset = io.getutable();

            while (io.rset.next()) {
                if (uname.equals(io.rset.getString("uname"))) {
                    mm.uname = uname;
                    return true;
                }
            }
            //statement.executeUpdate("INSERT INTO UTABLE VALUES ('"+ uname +  "')");
            io.setpstate("INSERT INTO UTABLE (UNAME) VALUES(?)");

            io.pstate.setString(1, uname);
            io.pstate.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
        mm.uname = uname;
        return true;
    }
}
