
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoadPetPanel extends JPanel {

    MainMenu mm;
    JButton selectbutton, cancelbutton;
    ArrayList<String> templist;
    JList<String> petlist;
    DefaultListModel<String> list;
    JScrollPane petscroll;
    JLabel info;
    LoadPet lp;
    Animal pet;

    public LoadPetPanel(MainMenu mainmenu) {
        this.mm = mainmenu;
        this.lp = new LoadPet(mm);
        
        // Jlabel
        this.info = new JLabel("Load a pet");
        this.add(this.info);

        // button select pet
        this.selectbutton = new JButton("Select");
        this.selectbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                selectbutton(evt);
            }
        });


    }
    
    public void initialise() {

        // list for pets
        this.templist = lp.nameslist(mm.uname);
        
        this.list = new DefaultListModel<>();
        for (int i = 0; i < templist.size(); i++) {
            this.list.addElement(this.templist.get(i));
        }
        //this.list.addElement("LFA");
        
        this.petlist = new JList<>(list);
        this.petlist.setBounds(100, 200, 75, 75);
        this.add(this.petlist);
        
        // show select button
        this.add(this.selectbutton);
        
        // button to go back to main menu
        this.cancelbutton = new JButton("Cancel");
        this.cancelbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cancelbutton(evt);
            }
        });
        this.add(this.cancelbutton);
        
    }
    
    public void uninitialise() {
        this.templist.clear();
        this.remove(this.petlist);
        this.remove(this.cancelbutton);
    }

    public void selectbutton(java.awt.event.ActionEvent evt) {
        int i = petlist.getSelectedIndex();
        if (i != -1) {
            
            mm.Pet = lp.load(i);
            uninitialise();
            mm.changeto_playmenu();

        } else {
            info.setText("Please select a pet to load");
        }
    }

    public void cancelbutton(java.awt.event.ActionEvent evt) {
        uninitialise();
        if (mm.Pet != null) {
            mm.changeto_playmenu();
        } else {
            mm.changeto_mainmenu();
        }
        

    }

}
