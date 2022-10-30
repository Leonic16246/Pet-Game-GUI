
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leon
 */
public class DBIO {

    private final DBManager dbManager;
    private Connection conn;
    private Statement statement;
    private PreparedStatement pstate;
    private String pstring;
    private ResultSet rset, pset, uset;
    private ArrayList<String> namelist;
    private ArrayList<Integer> typelist, moodlist;

    public DBIO() {

        namelist = new ArrayList<>();
        typelist = new ArrayList<>();
        moodlist = new ArrayList<>();
        pstring = "";
        rset = null;

        dbManager = new DBManager();
        conn = dbManager.getConnection();
        try {
            statement = conn.createStatement();
            pset = statement.executeQuery("SELECT * FROM PTABLE");
            uset = statement.executeQuery("SELECT * FROM UTABLE");
        } catch (SQLException ex) {
            Logger.getLogger(DBIO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // make bulk rsets from tables if needed
    public void initialiseList(String oname) {

        System.out.println("making list");
        rset = null;
        try {
            setpstate("SELECT PNAME, TYPE, MOOD FROM PTABLE WHERE ONAME LIKE (?)");
            pstate.setString(1, oname);

            rset = pstate.executeQuery();

            while (rset.next()) {
                namelist.add(rset.getString("pname"));
                typelist.add(rset.getInt(2));
                moodlist.add(rset.getInt(3));
                System.out.println(rset.getString("pname"));
                System.out.println(rset.getInt(2));
                System.out.println(rset.getInt(3));
            }

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
    }

    // return namelist
    public ArrayList<String> getnameList(String oname) {
        System.out.println("making namelist");
        rset = null;
        try {
            setpstate("SELECT PNAME FROM PTABLE WHERE ONAME LIKE (?)");
            pstate.setString(1, oname);

            rset = pstate.executeQuery();
            while (rset.next()) {
                namelist.add(rset.getString("pname"));
                System.out.println(rset.getString("pname"));

            }

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
        return this.namelist;
    }

    // return typelist
    public ArrayList<Integer> gettypeList(String oname) {
        System.out.println("making typelist");
        rset = null;
        try {
            setpstate("SELECT TYPE FROM PTABLE WHERE ONAME LIKE (?)");
            pstate.setString(1, oname);

            rset = pstate.executeQuery();
            while (rset.next()) {
                typelist.add(rset.getInt(1));
                System.out.println(rset.getInt(1));

            }

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
        return this.typelist;
    }

    // return moodlist
    public ArrayList<Integer> getmoodList(String oname) {
        System.out.println("making moodlist");
        rset = null;
        try {
            setpstate("SELECT MOOD FROM PTABLE WHERE ONAME LIKE (?)");
            pstate.setString(1, oname);

            rset = pstate.executeQuery();
            while (rset.next()) {
                moodlist.add(rset.getInt(1));
                System.out.println(rset.getInt(1));

            }

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
        return this.moodlist;
    }

    // save to db as a new pet
    public void newsave(String oname, String pname, int type, int mood) {

        System.out.println("saving");
        rset = null;
        try {
            setpstate("INSERT INTO PTABLE VALUES (?, ?, ?, ?)");
            pstate.setString(1, oname);
            pstate.setString(2, pname);
            pstate.setInt(3, type);
            pstate.setInt(4, mood);

            pstate.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
    }

    // save an existing pet by updating
    public void updatemood(String oname, String pname, int mood) {

        System.out.println("updating");
        rset = null;
        try {
            setpstate("UPDATE PTABLE SET MOOD=? WHERE ONAME=? AND PNAME=?");

            pstate.setInt(1, mood);
            pstate.setString(2, oname);
            pstate.setString(3, pname);
            pstate.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
    }

    // change pet type, for debugging (only?)
    public void changetype(String oname, String pname, int type) {

        System.out.println("changing type");
        rset = null;
        try {
            setpstate("UPDATE PTABLE SET TYPE=? WHERE ONAME=? AND PNAME=?");

            pstate.setInt(1, type);
            pstate.setString(2, oname);
            pstate.setString(3, pname);

            pstate.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
    }

    // delete a pet form db
    public void delete(String oname, String pname) {

        System.out.println("deleting");
        rset = null;
        try {
            setpstate("DELETE FROM PTABLE WHERE ONAME=? AND PNAME=?");

            pstate.setString(1, oname);
            pstate.setString(2, pname);
            int i = pstate.executeUpdate();
            System.out.println(i + "stat");

        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
        System.out.println("deleted?");

    }

    public PreparedStatement getpstate() {
        return pstate;
    }

    public void setpstring(String input) {
        this.pstring = input;
    }

    public void setpstate(String input) {
        try {
            this.pstate = conn.prepareStatement(input);
        } catch (SQLException ex) {
            Logger.getLogger(DBIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getrset() {
        return this.rset;
    }
    public void setrset(ResultSet set) {
        this.rset = set;
    }

    public ResultSet getptable() {
        return this.pset;
    }

    public ResultSet getutable() {
        return this.uset;
    }

    // for creating sample pet table 
    public void createptable() {

        try {
            statement = conn.createStatement();

            statement.executeUpdate("CREATE TABLE PTABLE (ONAME VARCHAR(20), PNAME VARCHAR(20), TYPE INT, MOOD INT)");
            statement.executeUpdate("INSERT INTO PTABLE VALUES ('Eugene', 'Amelia', 1, 60),\n" + "('Jake', 'Jordan', 1, 0),\n" + "('Jake', 'Paige', 2, 80)");
        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
    }

    // for creating sample user table
    public void createutable() {

        try {
            statement = conn.createStatement();

            statement.executeUpdate("CREATE TABLE UTABLE (UNAME VARCHAR(20))");
            statement.executeUpdate("INSERT INTO UTABLE VALUES ('Leon L'),\n" + "('Eugene'),\n" + "('Jake')");
        } catch (SQLException ex) {
            System.err.println("SQLEeption: " + ex.getMessage());
        }
    }

}
