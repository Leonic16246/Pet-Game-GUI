import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadPetPanel extends JPanel{
    
    MainMenu mm;

    JButton selectbutton, cancelbutton;
    JList<String> petlist;
    DefaultListModel<String> list;
    JScrollPane petscroll;
    JLabel petinfo;
    LoadPet lp;
    Animal pet;

    public LoadPetPanel(MainMenu mainmenu) {
        this.mm = mainmenu;
        this.lp = new LoadPet();



        // button select pet
        this.selectbutton = new JButton("Select");
        this.selectbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                selectbutton(evt);
            }
        });
        this.add(this.selectbutton);

        // list for pets
        this.list = new DefaultListModel<String>();
        // for (int i = 0; i < lp.namelist.size(); i++) {
        //     this.list.set(i, lp.namelist.get(i));
        // }
        this.list.addElement("Eugene");
        this.list.addElement("Amelia");

        this.petlist = new JList<>(list);
        // this.petlist.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent evt) {
        //         petlist(evt);
        //     }
        // });
        this.petlist.setBounds(100, 200, 75, 75);  
        this.add(this.petlist);


        // scroll pane for scrolling
        this.petscroll = new JScrollPane();
        this.add(this.petscroll);

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




    public void selectbutton(java.awt.event.ActionEvent evt) {
        if (petlist.getSelectedIndex() != -1) {
            System.out.println(petlist.getSelectedIndex());
            mm.changeto_playmenu();

        }
    }

    public void petscroll(java.awt.event.ActionEvent evt) {

    }

    public void cancelbutton(java.awt.event.ActionEvent evt) {

        mm.changeto_mainmenu();

    }


}
