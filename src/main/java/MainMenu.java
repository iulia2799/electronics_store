import com.sun.imageio.plugins.jpeg.JPEGImageMetadataFormatResources;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements ActionListener
{
    protected JFrame mainFrame = new JFrame();
    protected JPanel mainPanel = new JPanel();
    protected JButton signUp = new JButton("Sign Up");
    protected JButton signIn =new JButton("Sign In");
    protected JLabel welcomeLabel = new JLabel("Electronics Store management application");
    public void performMain()
    {
        mainFrame.setSize(400,500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);
        mainPanel.setLayout(null);
        //Signup
        signUp.setBounds(130,80,100,35);
        signUp.addActionListener(this);
        mainPanel.add(signUp);
        //Signin
        signIn.setBounds(130,130,100,35);
        signIn.addActionListener(this);
        mainPanel.add(signIn);
        //Label
        welcomeLabel.setBounds(30,0,350,140);
        mainPanel.add(welcomeLabel);
    }
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource()==signUp)
        {
            SignUp signup = new SignUp();
            signup.performAdmin();
           mainFrame.setVisible(false);
        }
    }
}
