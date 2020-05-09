import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

public class Employee implements ActionListener {
    protected JFrame employeeFrame = new JFrame();
    protected JPanel employeePanel = new JPanel();

    protected JButton viewProductsButton = new JButton("View Products");

    protected JButton viewTasksButton = new JButton("View Tasks");

    protected JButton backButton = new JButton("Back");

    public void performEmployee()
    {
        employeeFrame.setVisible(true);
        employeeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        employeeFrame.setSize(500,350);
        employeeFrame.add(employeePanel);
        employeePanel.setLayout(null);

        employeePanel.setSize(500,350);

        viewProductsButton.setBounds(100,20,200,35);
        employeePanel.add(viewProductsButton);
        viewProductsButton.addActionListener(this);

        viewTasksButton.setBounds(100,100,200,35);
        employeePanel.add(viewTasksButton);
        viewTasksButton.addActionListener(this);

        backButton.setBounds(150,180,100,35);
        employeePanel.add(backButton);
        backButton.addActionListener(this);


    }
    public void actionPerformed(ActionEvent action)
    {
        if(action.getSource()==viewProductsButton)
        {
            JOptionPane.showMessageDialog(employeeFrame,"YOU GOT PRANKED!");
        }
         if(action.getSource()==viewTasksButton)
        {
            JOptionPane.showMessageDialog(employeeFrame,"YOU GOT PRANKED!");
        }
        if(action.getSource()==backButton)
        {
            SignIn si = new SignIn();
            si.performSignIn();
            employeeFrame.setVisible(false);
        }
    }
}
