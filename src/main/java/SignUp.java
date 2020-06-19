import jdk.nashorn.internal.scripts.JO;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class SignUp implements ActionListener
{
    protected JFrame signUpFrame= new JFrame();
    protected JPanel signUpPanel=new JPanel();
    ///
    protected JFrame adminFrame = new JFrame();
    protected JPanel adminPanel = new JPanel();
    protected JLabel passwordLabel = new JLabel("Password:");
    protected JPasswordField passwordField = new JPasswordField();
    protected JButton connectAdminButton = new RoundButton("Connect Admin");
    //
    protected JButton backButton = new RoundButton("Back");
    ///
    ///
    protected JLabel usernameSignUpLabel = new JLabel("username");
    protected JLabel passwordSignUpLabel = new JLabel("password");
    ///
    protected JTextField usernameTextSU = new JTextField();
    protected JPasswordField passwordTextSU = new JPasswordField();
    protected JButton createAccount= new RoundButton("Create account");
    protected JCheckBox employeeCheckBox = new JCheckBox("Employee");
    protected JCheckBox managerCheckBox = new JCheckBox("Manager");
    public void performAdmin() {
        adminFrame.setSize(300, 300);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setVisible(true);
        adminFrame.add(adminPanel);
        adminFrame.setLocationRelativeTo(null);
        adminPanel.setLayout(null);
        //Label
        passwordLabel.setBounds(10,20,140,130);
        adminPanel.add(passwordLabel);
        //PasswordField
        passwordField.setBounds(10,100,140,35);
        adminPanel.add(passwordField);
        adminPanel.setBackground(new Color(135,72,72));
        //Connect
        connectAdminButton.setBounds(10,160,160,55);
        connectAdminButton.addActionListener(this);
        adminPanel.add(connectAdminButton);
        //Back Button
        backButton.setBounds(180,160,90,55);
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
        signUpFrame.setLocationRelativeTo(null);
        signUpPanel.setBackground(new Color(135,72,72));
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
        //Employee check box
        employeeCheckBox.setBounds(10,180,100,35);
        signUpPanel.add(employeeCheckBox);
        employeeCheckBox.setBackground(new Color(135,72,72));
        //Manager Check box
        managerCheckBox.setBounds(130,180,100,35);
        signUpPanel.add(managerCheckBox);
        managerCheckBox.setBackground(new Color(135,72,72));
        //connect Button
        createAccount.setBounds(60,240,160,55);
        createAccount.addActionListener(this);
        signUpPanel.add(createAccount);
        //backbutton
        backButton.setBounds(280,240,90,55);
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
        if(actionEvent.getSource()==createAccount) {
            String pass = "";
            String user = "";
            String type = "";
            if (employeeCheckBox.isSelected()) {
                type += "employee";
            } else if (managerCheckBox.isSelected()) {
                type += "manager";
            }
            char[] passformat = passwordTextSU.getPassword();
            for (char i : passformat) {
                pass += i;
            }
            user += usernameTextSU.getText();
            //////
            AddUser userObj = new AddUser();
            Encryption e = new Encryption();
            try {
                userObj.readJSON(user,e.encodePassword(pass), type);
            } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                noSuchAlgorithmException.printStackTrace();
            }
            ////
            if (!userObj.isUsername && !userObj.isPassword) {
                if(employeeCheckBox.isSelected() ^ managerCheckBox.isSelected()) {
                    try {
                        userObj.addUser(user, e.encodePassword(pass), type);
                    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                        noSuchAlgorithmException.printStackTrace();
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(signUpFrame, "Cont existent ,incercati alt username sau parola!");
                usernameTextSU.setText(null);
                passwordTextSU.setText(null);
            }
            ////
            if (employeeCheckBox.isSelected() && managerCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(signUpFrame, "Invalida optiune pentru tipul de cont");
            }
            if (!employeeCheckBox.isSelected() && !managerCheckBox.isSelected()) {
                JOptionPane.showMessageDialog(signUpFrame, "Alegeti tipul contului");
            }
            ////////
        }
    }
}
