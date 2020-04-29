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
    public void performMain()
    {
        mainFrame.setSize(350,350);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);
        mainPanel.setLayout(null);
        //Signup
        signUp.setBounds(10,20,100,35);
        signUp.addActionListener(this);
        mainPanel.add(signUp);
        //Signin
        signIn.setBounds(10,45,100,35);
        signIn.addActionListener(this);
        mainPanel.add(signIn);
    }
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
