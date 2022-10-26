import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPanel extends JPanel{
    
    JButton playwithbutton, loadbutton, quitbutton;
    JLabel pic;
    MainMenu mm;
    Animal pet;



    public PlayPanel(MainMenu mainmenu) {

        this.mm = mainmenu;

        // button to play with pet
        this.playwithbutton = new JButton("Play with pet");
        this.playwithbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent evt ) {
                playwithbutton(evt);
            }
        });
        this.add(this.playwithbutton);


        // button for load pet
        this.loadbutton = new JButton("Load pet");
        this.loadbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent evt ) {
                loadbutton(evt);
            }
        });
        this.add(this.loadbutton);

        // button to go back to main menu
        this.quitbutton = new JButton("Quit to main menu");
        this.quitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                quitbutton(evt);
            }
        });
        this.add(this.quitbutton);

    }

    public void loadbutton(java.awt.event.ActionEvent evt) {

        mm.card.show(mm.mainpanel, "loadpetmenu");

    }

    public void quitbutton(java.awt.event.ActionEvent evt) {

        mm.card.show(mm.mainpanel, "mainmenu");

    }

    public void playwithbutton(java.awt.event.ActionEvent evt) {



    }

}
