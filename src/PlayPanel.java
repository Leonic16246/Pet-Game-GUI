
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayPanel extends JPanel {
    
    JButton playwithbutton, loadbutton, savebutton, deletebutton, quitbutton;
    JLabel info;
    MainMenu mm;
    boolean confirm;
    
    public PlayPanel(MainMenu mainmenu) {
        
        this.mm = mainmenu;
        this.confirm = false;
        
    }
    
    public void initialise() {
        
        this.info = new JLabel(mm.Pet.getName() + " wants to play!");
        this.add(this.info);

        // button to play with pet
        this.playwithbutton = new JButton("Play with pet");
        this.playwithbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                playwithbutton(evt);
            }
        });
        this.add(this.playwithbutton);

        // button to load pet
        this.loadbutton = new JButton("Load pet");
        this.loadbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loadbutton(evt);
            }
        });
        this.add(this.loadbutton);

        // button to save pet to db
        this.savebutton = new JButton("Save pet");
        this.savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                savebutton(evt);
            }
        });
        this.add(this.savebutton);

        // button to delete pet
        this.deletebutton = new JButton("Delete pet");
        this.deletebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                deletebutton(evt);
            }
        });
        this.add(this.deletebutton);

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
    
    public void uninitialise() {
        this.remove(this.info);
        this.remove(this.playwithbutton);
        this.remove(this.loadbutton);
        this.remove(this.savebutton);
        this.remove(this.deletebutton);
        this.remove(this.quitbutton);
    }
    
    public void playwithbutton(java.awt.event.ActionEvent evt) {
        
        PlaywithPet pwp = new PlaywithPet();
        pwp.playwith(mm.Pet);
        info.setText(mm.Pet.Mood());
        
    }
    
    public void loadbutton(java.awt.event.ActionEvent evt) {
        uninitialise();
        mm.loadpetpanel.initialise(); // to make the list of user's pets after they log in
        mm.changeto_loadpetmenu();
        
        
    }
    
    public void savebutton(java.awt.event.ActionEvent evt) {
        info.setText("Saving");
        SavePet sp = new SavePet();
        sp.save(mm.Pet, mm.uname);
        info.setText("Saved!");
        
    }
    
    public void deletebutton(java.awt.event.ActionEvent evt) {
        
        if (confirm == false) {
            confirm = true;
            info.setText("Press again to confirm deletion of " + mm.Pet.getName());
        } else {
            DeletePet dp = new DeletePet(mm);
            dp.delete(mm.uname, mm.Pet.getName());
            confirm = false;
            uninitialise();
            mm.changeto_mainmenu();
        }
        
    }
    
    public void quitbutton(java.awt.event.ActionEvent evt) {
        uninitialise();
        mm.changeto_mainmenu();
        
    }
    
}
