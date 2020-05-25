import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;


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
    protected JCheckBox employeeCheckBox = new JCheckBox("Employee");
    protected JCheckBox managerCheckBox = new JCheckBox("Manager");
    public void performSignIn(){
        signInFrame.setVisible(true);
        signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signInFrame.setSize(500,350);
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
        //Employee check box
        employeeCheckBox.setBounds(10,150,100,30);
        signInPanel.add(employeeCheckBox);
        //Manager Check box
        managerCheckBox.setBounds(130,150,100,30);
        signInPanel.add(managerCheckBox);
        connectSIButton.setBounds(10,200,100,35);
        signInPanel.add(connectSIButton);
        connectSIButton.addActionListener(this);
        ///
        backSIButton.setBounds(150,200,100,35);
        signInPanel.add(backSIButton);
        backSIButton.addActionListener(this);
    }


    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==connectSIButton)
        {    String pass="";
             String user="";
             String type="";
             if(employeeCheckBox.isSelected())
             {
                 type+="employee";
             }
             else if(managerCheckBox.isSelected())
             {
                 type+="manager";
             }
             char[] passformat =passwordSIField.getPassword();
             for(char i : passformat)
             {
                 pass+=i;
             }
             user=usernameSITextField.getText();

             AddUser userSearch = new AddUser();
             Encryption encryption = new Encryption();

             try{
                 userSearch.readJSON(user,encryption.encodePassword(pass),type);
             }catch (NoSuchAlgorithmException ex){
                 ex.printStackTrace();
             }
             if(userSearch.isUsername && userSearch.isPassword)
             {
                 //JOptionPane.showMessageDialog(signInFrame,"LOGGED IN");
                 if(type.equals("employee"))
                 {
                     Employee employee = new Employee(user);
                     employee.performEmployee(user);
                     signInFrame.setVisible(false);
                 }
                 if(type.equals("manager"))
                 {
                     Manager manager = new Manager();
                     manager.performManager();
                     signInFrame.setVisible(false);
                 }
             }
             else
             {
                 JOptionPane.showMessageDialog(signInFrame,"Username sau parola sau tip incorect");
             }

            //JOptionPane.showMessageDialog(signInFrame,"YOU GOT PRANKED!");
        }
        if(actionEvent.getSource()==backSIButton)
        {
            MainMenu sm = new MainMenu();
            sm.performMain();
            signInFrame.setVisible(false);
        }

    }
}
