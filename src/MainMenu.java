import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class MainMenu extends JFrame{
    
    String uname;
    Animal Pet;
    CardLayout card;
    UserPanelF userpanel;
    MainPanelF menupanel;
    NewPetPanelF newpetpanel;
    LoadPetPanelF loadpetpanel;
    PlayPanelF playpanel;
    JPanel mainpanel;


    // constructor (to initialise frame)
    public MainMenu() {

        this.Pet = null;
        this.uname = "";
        
        this.setSize(600, 450);

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
        playpanel.initialise();
        this.card.show(mainpanel, "playmenu");

    }
    

    // initialise panel for main menu
    public void initialisemainpanel() {
        //this.card.next(this);
        // make frame visible
        // this.newpet.setBounds(this.getWidth()/2 - 100, this.getHeight()/3, 200, 50);
        // this.loadpet.setBounds(this.getWidth()/2 - 100, this.getHeight()/2, 200, 50);
        // this.quit.setBounds(this.getWidth()/2 -100, this.getHeight() - 100, 200, 50);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

    }

    public static void main(String[] args) throws Exception { // Main menu to create or load a pet or exit game
        DBIO io = new DBIO();
        //io.createptable();
        //io.createutable();
        
        MainMenu mainmenu = new MainMenu();
        // mainmenu.initialisemainpanel();
    }



}
 