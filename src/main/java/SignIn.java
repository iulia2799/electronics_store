import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SignIn implements ActionListener{

    protected JFrame signInFrame =new JFrame();
    protected JPanel signInPanel =new JPanel();
    ///username field
    protected JLabel usernameSILabel = new JLabel("Username:");
    protected JTextField usernameSITextField = new JTextField();
    ///password field
    protected JLabel passwordSILabel = new JLabel("Password:");
    protected JPasswordField passwordSIField = new JPasswordField();
    ///connect button
    protected JButton connectSIButton = new JButton("Sign in");
    ///
    protected JButton backSIButton = new JButton("Back");
    ///
    public void performSignIn(){
        signInFrame.setVisible(true);
        signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signInFrame.setSize(600,600);
        signInFrame.add(signInPanel);
        signInPanel.setLayout(null);
        ///
        usernameSILabel.setBounds(10,20,140,35);
        usernameSITextField.setBounds(10,50,140,35);
        signInPanel.add(usernameSILabel);
        signInPanel.add(usernameSITextField);
        ///
        passwordSILabel.setBounds(10,80,140,35);
        passwordSIField.setBounds(10,110,140,35);
        signInPanel.add(passwordSILabel);
        signInPanel.add(passwordSIField);
        ///
        connectSIButton.setBounds(10,150,100,35);
        signInPanel.add(connectSIButton);
        ///
        backSIButton.setBounds(150,150,100,35);
        signInPanel.add(backSIButton);
    }


    public void actionPerformed(ActionEvent e) {

    }
}
