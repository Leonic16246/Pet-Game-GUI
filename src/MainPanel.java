
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {

    JLabel title;
    JButton newpet, loadpet, quit, logout;
    Animal Pet;
    int select;// 0 for main, 1 to for new, 2 to load, 3 for play // to-do
    MainMenu mm;

    public MainPanel() {

        //this.setLayout(new BorderLayout());
        //this.mm = mainmenu;

        this.Pet = null;
        this.select = 0;

        this.title = new JLabel("Pet simulator");
        this.add(title);

        // button for new pet
        this.newpet = new JButton("New Pet");
        this.newpet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                newbutton(evt);
            }
        });
        this.add(this.newpet);

        // button for load pet
        this.loadpet = new JButton("Load Pet");
        this.loadpet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loadbutton(evt);
            }
        });
        this.add(this.loadpet);

        // button to log out
        this.logout = new JButton("Log out");
        this.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                logoutbutton(evt);
            }
        });
        this.add(this.logout);

        // button to quit
        this.quit = new JButton("Quit");
        this.quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                exitbutton(evt);
            }
        });
        this.add(this.quit);

        //this.add(this, BorderLayout.CENTER); // add panel to fram
    }

    public void newbutton(java.awt.event.ActionEvent evt) {

        mm.changeto_newpetmenu();
    }

    public void loadbutton(java.awt.event.ActionEvent evt) {

        mm.loadpetpanel.initialise(); // to make the list of user's pets after they log in
        if (mm.loadpetpanel.templist.isEmpty()) {
            this.title.setText("No pets found, please create one");
        } else {
            mm.changeto_loadpetmenu();
        }

    }

    public void logoutbutton(java.awt.event.ActionEvent evt) {

        mm.changeto_usermenu();

    }

    public void exitbutton(java.awt.event.ActionEvent evt) {

        System.exit(ABORT);

    }

}
