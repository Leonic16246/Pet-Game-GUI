import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenu extends JFrame{
    
    private String uname;
    private Animal pet;
    private final CardLayout card;
    private final UserPanelF userpanel;
    private final MainPanelF menupanel;
    private final NewPetPanelF newpetpanel; // not private to call function from panels
    final LoadPetPanelF loadpetpanel;
    private final PlayPanelF playpanel;
    private final JPanel mainpanel;


    // constructor (to initialise frame)
    public MainMenu() {

        this.pet = null;
        this.uname = "";
        
        this.setSize(600, 500);

        // cardlayout
        this.card = new CardLayout();
        this.mainpanel = new JPanel(this.card);

        // game panels
        this.userpanel = new UserPanelF(this);
        mainpanel.add(userpanel, "usermenu");
        this.menupanel = new MainPanelF(this);
        mainpanel.add(menupanel, "mainmenu");
        this.newpetpanel = new NewPetPanelF(this);
        mainpanel.add(newpetpanel, "newpetmenu");
        this.loadpetpanel = new LoadPetPanelF(this);
        mainpanel.add(loadpetpanel, "loadpetmenu");
        this.playpanel = new PlayPanelF(this);
        mainpanel.add(playpanel, "playmenu");

        this.add(mainpanel);

        // frame
        this.setTitle("Virtual Pet Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    
    // gets/sets
    public String getuname() {
        return this.uname;
    }
    public void setuname(String uname) {
        this.uname = uname;
    }
    public Animal getpet() {
        return this.pet;
    }
    public void setpet(Animal pet) {
        this.pet = pet;
    }
    
    public void changeto_usermenu() {
        this.card.show(mainpanel, "usermenu");

    }
    public void changeto_mainmenu() {
        this.card.show(mainpanel, "mainmenu");

    }
    public void changeto_newpetmenu() {
        this.card.show(mainpanel, "newpetmenu");

    }
    public void changeto_loadpetmenu() {
        
        this.card.show(mainpanel, "loadpetmenu");

    }
    public void changeto_playmenu() {
        
        this.card.show(mainpanel, "playmenu");
        try {
            playpanel.initialise();
        } catch (Exception ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }

    public static void main(String[] args) throws Exception { // Main menu to create or load a pet or exit game
        
        DBIO io = new DBIO();
        
        // for testing
        //io.createptable();
        //io.createutable();
        
        MainMenu mainmenu = new MainMenu();
        
    }



}
 