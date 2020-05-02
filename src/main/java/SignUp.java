import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp implements ActionListener
{
    protected JFrame signUpFrame= new JFrame();
    protected JPanel signUpPanel=new JPanel();
    ///
    protected JFrame adminFrame = new JFrame();
    protected JPanel adminPanel = new JPanel();
    protected JLabel passwordLabel = new JLabel("Password:");
    protected JPasswordField passwordField = new JPasswordField();
    protected JButton connectAdminButton = new JButton("Connect Admin");
    //
    protected JButton backButton = new JButton("Back");
    ///
    ///
    protected JLabel usernameSignUpLabel = new JLabel("username");
    protected JLabel passwordSignUpLabel = new JLabel("password");
    protected JLabel typeofAccount = new JLabel("Type of account");
    ///
    protected JTextField usernameTextSU = new JTextField();
    protected JPasswordField passwordTextSU = new JPasswordField();
    protected JTextField typeofAccountField=  new JTextField();
    protected JButton createAccount  = new JButton("Create account");

    public void performAdmin() {
        adminFrame.setSize(300, 300);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setVisible(true);
        adminFrame.add(adminPanel);
        adminPanel.setLayout(null);
        //Label
        passwordLabel.setBounds(10,20,140,130);
        adminPanel.add(passwordLabel);
        //PasswordField
        passwordField.setBounds(10,90,140,35);
        adminPanel.add(passwordField);
        //Connect
        connectAdminButton.setBounds(10,160,160,35);
        connectAdminButton.addActionListener(this);
        adminPanel.add(connectAdminButton);
        //Back Button
        backButton.setBounds(180,160,90,35);
        backButton.addActionListener(this);
        adminPanel.add(backButton);
    }
    public void performSignUp()
    {
        signUpFrame.setSize(500,350);
        signUpFrame.setVisible(true);
        signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signUpFrame.add(signUpPanel);
        signUpPanel.setLayout(null);
        //username Label
        usernameSignUpLabel.setBounds(10,10,110,100);
        signUpPanel.add(usernameSignUpLabel);
        //username Text field
        usernameTextSU.setBounds(10,70,140,35);
        signUpPanel.add(usernameTextSU);
        //password Label
        passwordSignUpLabel.setBounds(10,65,110,100);
        signUpPanel.add(passwordSignUpLabel);
        //password Text field
        passwordTextSU.setBounds(10,125,140,35);
        signUpPanel.add(passwordTextSU);
        //type label
        typeofAccount.setBounds(10,125,130,100);
        signUpPanel.add(typeofAccount);
        //type text field
        typeofAccountField.setBounds(10,190,140,35);
        signUpPanel.add(typeofAccountField);
        //connect Button
        createAccount.setBounds(100,245,160,35);
        createAccount.addActionListener(this);
        signUpPanel.add(createAccount);
        //backbutton
        backButton.setBounds(280,245,90,35);
        backButton.addActionListener(this);
        signUpPanel.add(backButton);
    }
    public void actionPerformed(ActionEvent actionEvent)
    {

        if(actionEvent.getSource()==connectAdminButton)
        {
            String finaladminPass="";
            char[] password = passwordField.getPassword();
            for(char i : password)
            {
                finaladminPass+=i;
            }
            if(finaladminPass.equals("admin"))
            {
                performSignUp();
                adminFrame.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(adminFrame,"Parola admin incorecta!");
            }
            passwordField.setText(null);
            for(char i : password)
            {
                i=' ';
            }
        }
        if(actionEvent.getSource()==backButton)
        {
            MainMenu mm = new MainMenu();
            mm.performMain();
            adminFrame.setVisible(false);
            signUpFrame.setVisible(false);
        }
    }
}
