
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Leon
 */
public class UserPanel extends JPanel {

    JLabel infolabel;
    //String uname;
    JButton loginbutton, quitbutton;
    JTextField usernamefield;
    MainMenu mm;
    UserLogin login;

    public UserPanel(MainMenu mainmenu) {

        this.mm = mainmenu;
        this.setSize(800, 500);
        this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));

        // label
        this.infolabel = new JLabel("Enter username");
        this.infolabel.setSize(200, 100);
        this.add(this.infolabel);
        this.add(Box.createRigidArea(new Dimension(0, 5)));

        // textfield to input username
        this.usernamefield = new JTextField();
        this.usernamefield.setSize(400, 200);
        this.add(this.usernamefield);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        
        // button to login
        this.loginbutton = new JButton("Login");
        this.loginbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loginbutton(evt);
            }
        });
        //this.loginbutton.setSize(100,100);
        this.add(this.loginbutton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        
        // button to login
        this.quitbutton = new JButton("Quit");
        this.quitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                quitbutton(evt);
            }
        });
        this.add(this.quitbutton);
        this.add(Box.createRigidArea(new Dimension(0, 5)));
        
        
    }

    
    public void loginbutton(java.awt.event.ActionEvent evt) {

        String name = usernamefield.getText();
        this.login = new UserLogin(mm);
        if (login.login(name)) {

            //usernamefield.setText("Username");
            mm.changeto_mainmenu();
        } else {
            infolabel.setText("Please input a name");
        }

    }

    public void quitbutton(java.awt.event.ActionEvent evt) {

        System.exit(ABORT);

    }

}
