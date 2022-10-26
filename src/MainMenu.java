import java.awt.Graphics;
import javax.swing.JFrame;

import javax.swing.JPanel;


import java.awt.CardLayout;

public class MainMenu extends JFrame{
    
    Animal Pet;
    CardLayout card;
    MenuPanel menupanel;
    NewPetPanel newpetpanel;
    LoadPetPanel loadpetpanel;
    PlayPanel playpanel;
    JPanel mainpanel;


    // constructor (to initialise frame)
    public MainMenu() {

        this.Pet = null;

        // cardlayout
        this.card = new CardLayout();
        this.mainpanel = new JPanel(this.card);

        // game panels
        this.menupanel = new MenuPanel(this);
        mainpanel.add(menupanel, "mainmenu");
        this.newpetpanel = new NewPetPanel(this);
        mainpanel.add(newpetpanel, "newpetmenu");
        this.loadpetpanel = new LoadPetPanel(this);
        mainpanel.add(loadpetpanel, "loadpetmenu");
        this.playpanel = new PlayPanel(this);
        mainpanel.add(playpanel, "playmenu");

        this.add(mainpanel);

        // frame
        this.setTitle("Virtual Pet Game");
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

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

        repaint();

    }


    public static void main(String[] args) throws Exception { // Main menu to create or load a pet or exit game

        MainMenu mainmenu = new MainMenu();
        // mainmenu.initialisemainpanel();
    }



}
 