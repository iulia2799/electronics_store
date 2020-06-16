import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee implements ActionListener{
    protected JFrame employeeFrame = new JFrame();
    protected JPanel employeePanel = new JPanel();
    protected JButton viewProductsButton = new JButton("View Products");
    protected JButton viewTasksButton = new JButton("View Tasks");
    protected JButton backButton = new JButton("Back");
    String username="";
    String products ="";
    public Employee(String username)
    {
        this.username = username;
    }
    public String getUsername(){return username;}
    public void performViewProducts()
    {
        final JFrame viewProductsFrame = new JFrame();
        final JTextArea viewProductsText = new JTextArea(10 ,20);
        JScrollPane scroll = new JScrollPane(viewProductsText,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        viewProductsFrame.setVisible(true);
        viewProductsFrame.setSize(400,400);
        viewProductsFrame.add(scroll);

        viewProductsText.setLineWrap(true);
        viewProductsText.setWrapStyleWord(true);
        viewProductsText.setText(products+"\n");
        viewProductsFrame.repaint();
        viewProductsFrame.setResizable(true);
    }
   String tasks="";

    public void performViewTasks(String username)
    {
        final JFrame taskFrame = new JFrame();
        final JPanel taskPanel = new JPanel();
        //JScrollPane scrollTasks = new JScrollPane(taskPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        taskFrame.setVisible(true);
        taskFrame.setSize(500,500);
       // taskFrame.add(scrollTasks);
        //taskFrame.add(taskPanel);
        taskPanel.setSize(400,400);



        TaskTabelModel model = new TaskTabelModel(username);
        JTable table = new JTable(model);

// Create a couple of columns
       // model.addColumn("Task description");
       // model.addColumn("Realized");

// Append a row
       String parts = tasks.replaceAll("[^A-Za-z .]",";");
       String[] arrstr =parts.split("[;]+");
       int i=1;
       for( String it : arrstr){
           if(!it.isEmpty())
           { model.addRow(new Object[]{i,it, false});
           i++;}
       }




        taskFrame.add(new JScrollPane(table));
        //taskPanel.add(table);
        //table.getCellEditor();



        taskFrame.setResizable(true);

    }
    public void deleteTasks(String task)
    {
        AddTasks DEL = new AddTasks();
        DEL.deleteTask(task,this.getUsername());

    }
    public void performEmployee(String username)
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
            //JOptionPane.showMessageDialog(employeeFrame,"YOU GOT PRANKED!");
            AddProducts p = new AddProducts();
            products+=p.readProducts();
            performViewProducts();
        }
         if(action.getSource()==viewTasksButton)
        {
            //JOptionPane.showMessageDialog(employeeFrame,"YOU GOT PRANKED!");
            AddTasks employee = new AddTasks();
            tasks=employee.viewTasks(username);
            performViewTasks(this.username);
        }
        if(action.getSource()==backButton)
        {
            SignIn si = new SignIn();
            si.performSignIn();
            employeeFrame.setVisible(false);
        }
    }
}
