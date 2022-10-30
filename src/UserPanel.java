
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.setSize(600, 600);
        this.setLayout(new GridLayout(10, 10));

        // label
        this.infolabel = new JLabel("Enter username");
        this.add(this.infolabel);

        // textfield to input username
        this.usernamefield = new JTextField("Username");
        this.add(this.usernamefield);

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

        // button to login
        this.quitbutton = new JButton("Quit");
        this.quitbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                quitbutton(evt);
            }
        });
        this.add(this.quitbutton);

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
