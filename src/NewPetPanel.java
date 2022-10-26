import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NewPetPanel extends JPanel {
    
    JLabel title;
    JButton dogbutton, catbutton, createbutton, cancelbutton;
    JTextField petnamefield;
    String petname;
    int pettype;
    NewPet np;
    MainMenu mm;
    Animal pet;

    public NewPetPanel(MainMenu mainmenu) {

        this.np = new NewPet();
        this.mm = mainmenu;
        this.pet = null;
        this.petname = "Enter pet name here";

        this.title = new JLabel("Choose your pet");
        this.add(title);

        // button to choose dog
        this.dogbutton = new JButton("Dog");
        this.dogbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                dogbutton(evt);
            }
        });
        this.add(this.dogbutton);

        // button to choose cat
        this.catbutton = new JButton("Cat");
        this.catbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                catbutton(evt);
            }
        });
        this.add(this.catbutton);

        // textfield for pet name
        this.petnamefield = new JTextField(this.petname);
        this.petnamefield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                petnamefield(evt);
            }
        });
        this.add(this.petnamefield);


        // button to create pet
        this.createbutton = new JButton("Create");
        this.createbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                createbutton(evt);
            }
        });
        this.add(this.createbutton);

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


    public void dogbutton(java.awt.event.ActionEvent evt) {
        //NewPet np = new NewPet(this);
        //Pet = np.newPet();
        // this.select = 1;
        // this.card.show(mainpanel, "newpetmenu");
        this.pettype = 1;
        this.title.setText("Dog selected");
    }

    public void catbutton(java.awt.event.ActionEvent evt) {

        this.pettype = 2;
        this.title.setText("Cat selected");
    }

    public void petnamefield(java.awt.event.ActionEvent evt) {


    }

    public void createbutton(java.awt.event.ActionEvent evt) {
        this.petname = this.petnamefield.getText();
        this.pet = np.newPet(pettype, petname);

        if (this.pet != null) {
            mm.Pet = this.pet;
            mm.changeto_playmenu();

            this.petname = "Enter pet name here";
            this.title.setText(this.petname);
            this.pettype = 0;
        } else {
            this.title.setText("Please select the type or enter a name");
        }
        
    }

    public void cancelbutton(java.awt.event.ActionEvent evt) {

        mm.changeto_mainmenu();

    }


}
