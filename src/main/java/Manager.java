import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import static java.awt.Adjustable.VERTICAL;

public class Manager implements ActionListener
{
    protected JFrame managerFrame = new JFrame();
    protected JPanel managerPanel =new JPanel();
    protected JButton showInventory = new JButton("Show inventory");
    protected JButton addInInventory = new JButton("Add in inventory");
    protected JButton addTasks = new JButton("Add Tasks");
    protected JButton signOut = new JButton("Sign Out");
    public void performManager()
    {
        //create Frame
        managerFrame.setSize(400,400);
        managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        managerFrame.setVisible(true);
        managerFrame.add(managerPanel);
        managerFrame.setLocationRelativeTo(null);
        managerPanel.setLayout(null);
        managerPanel.setBackground(new Color(135,72,72));
        //Perform panel
        showInventory.setBounds(110,25,150,35);
        managerPanel.add(showInventory);
        showInventory.addActionListener(this);
        showInventory.setBackground(new Color(104,136,225));
        //
        addInInventory.setBounds(110,65,150,35);
        managerPanel.add(addInInventory);
        addInInventory.addActionListener(this);
        addInInventory.setBackground(new Color(104,136,225));
        //
        addTasks.setBounds(110,105,150,35);
        addTasks.addActionListener(this);
        addTasks.setBackground(new Color(104,136,225));
        managerPanel.add(addTasks);
        //
        signOut.setBounds(110,165,150,35);
        managerPanel.add(signOut);
        signOut.addActionListener(this);
        signOut.setBackground(new Color(104,136,105));
    }
    //
    protected JFrame addProducsFrame = new JFrame();
    protected JPanel addProductsPanel = new JPanel();
    protected JLabel nameOfProduct = new JLabel("Name of product:");
    protected JTextField nameOfProductField = new JTextField();
    protected JLabel quantity = new JLabel("Quantity:");
    protected JTextField quantityField = new JTextField();
    protected JLabel priceOfproduct = new JLabel("Price of product:");
    protected JTextField priceOfProductField = new JTextField();
    protected JButton addProducts = new JButton("Add product");
    protected JButton backButton = new JButton("Back");
    //
    public void performAddProduct()
    {
        addProducsFrame.setSize(350,350);
        addProducsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addProducsFrame.setVisible(true);
        addProducsFrame.add(addProductsPanel);
        addTaskFrame.setLocationRelativeTo(null);
        //
        addProductsPanel.setLayout(null);
        //
        nameOfProduct.setBounds(10,20,140,35);
        addProductsPanel.add(nameOfProduct);
        nameOfProductField.setBounds(10,45,120,40);
        addProductsPanel.add(nameOfProductField);
        //
        quantity.setBounds(10,80,120,35);
        addProductsPanel.add(quantity);
        quantityField.setBounds(10,105,120,40);
        addProductsPanel.add(quantityField);
        //
        priceOfproduct.setBounds(10,145,120,35);
        addProductsPanel.add(priceOfproduct);
        priceOfProductField.setBounds(10,175,120,40);
        addProductsPanel.add(priceOfProductField);
        //
        addProducts.setBounds(85,240,120,40);
        addProducts.addActionListener(this);
        addProductsPanel.add(addProducts);
        //
        backButton.setBounds(215,240,100,40);
        addProductsPanel.add(backButton);
        backButton.addActionListener(this);
    }
    //
    protected JFrame addTaskFrame = new JFrame();
    protected JPanel addTaskPanel = new JPanel();
    protected JLabel nameofEmployee = new JLabel("Name of employee:");
    protected JTextField nameOfEmployeeField = new JTextField();
    protected JLabel taskLabel = new JLabel("Task:");
    protected JTextField taskLabelField = new JTextField();
    protected JButton addTask = new JButton("Add Task");
    //pentru adaugarea taskurilor va fi un nou fisier json care va contine numele si o lista de task-uri pentru angajatul
    //respectiv
    public void performAddTask()
    {
        addTaskFrame.setSize(350,350);
        addTaskFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addTaskFrame.setVisible(true);
        addTaskFrame.add(addTaskPanel);
        addTaskFrame.setLocationRelativeTo(null);
        //
        addTaskPanel.setLayout(null);
        //
        nameofEmployee.setBounds(10,20,120,40);
        addTaskPanel.add(nameofEmployee);
        nameOfEmployeeField.setBounds(10,50,120,40);
        addTaskPanel.add(nameOfEmployeeField);
        //
        taskLabel.setBounds(10,80,120,40);
        addTaskPanel.add(taskLabel);
        taskLabelField.setBounds(10,110,120,40);
        addTaskPanel.add(taskLabelField);
        //
        addTask.setBounds(85,160,120,40);
        addTask.addActionListener(this);
        addTaskPanel.add(addTask);
        //
        backButton.setBounds(215,160,100,40);
        addTaskPanel.add(backButton);
        backButton.addActionListener(this);
    }
    //Show inventory
    String inventory="";

   // protected JPanel inventoryPanel = new JPanel();

    public void performShowInventory()
    {
        final JFrame showInventoryFrame = new JFrame();
        final JTextArea inventoryLabel = new JTextArea(10,20);
        JScrollPane scroll = new JScrollPane(inventoryLabel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //JScrollBar heightBar = new JScrollBar(JScrollBar.HORIZONTAL,30,20,0,500);
       // JScrollBar verticalBar =new JScrollBar(JScrollBar.VERTICAL,30,40,0,500);
        class AdjustmentLis implements AdjustmentListener  //not needed
        {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
                inventoryLabel.setText(inventory+"\n");
                showInventoryFrame.repaint();

            }
        }
       // heightBar.addAdjustmentListener(new AdjustmentLis());
       // verticalBar.addAdjustmentListener(new AdjustmentLis());

        showInventoryFrame.setVisible(true);
        showInventoryFrame.setSize(400,400);
        showInventoryFrame.setLocationRelativeTo(null);
        showInventoryFrame.add(scroll);

        inventoryLabel.setLineWrap(true);
        inventoryLabel.setWrapStyleWord(true);
        inventoryLabel.setText(inventory+"\n");
        showInventoryFrame.repaint();
       // showInventoryFrame.getContentPane().add(inventoryLabel);
      //  showInventoryFrame.getContentPane().add(heightBar,BorderLayout.SOUTH);
       // showInventoryFrame.getContentPane().add(verticalBar,BorderLayout.EAST);
        showInventoryFrame.setResizable(true);

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource()==signOut)
        {
            MainMenu sm = new MainMenu();
            sm.performMain();
            managerFrame.setVisible(false);
        }
        if(actionEvent.getSource()==addInInventory)
        {
            performAddProduct();
            managerFrame.setVisible(false);
        }
        if(actionEvent.getSource()==addProducts)
        {
            String nameOf = nameOfProductField.getText();
            String quantityText = quantityField.getText();
            String priceOfProd = priceOfProductField.getText();
            //
            int quantity = Integer.parseInt(quantityText);
            double price = Double.parseDouble(priceOfProd);
            //
            AddProducts add = new AddProducts();
            add.addProduct(nameOf,quantity,price);
            //
            nameOfProductField.setText(null);
            quantityField.setText(null);
            priceOfProductField.setText(null);
        }
        //butonul din panelul managerului
        if(actionEvent.getSource()==addTasks)
        {
            performAddTask();
            managerFrame.setVisible(false);
        }
        //butonul din AddTasks
        if(actionEvent.getSource()==addTask)
        {
            String nameOf = nameOfEmployeeField.getText();
            String task = taskLabelField.getText();
            AddTasks addTasks = new AddTasks();
            addTasks.addTask(nameOf,task);
            //
            nameOfEmployeeField.setText(null);
            taskLabelField.setText(null);
        }
        if(actionEvent.getSource()==backButton)
        {
            performManager();
            addProducsFrame.setVisible(false);
            addTaskFrame.setVisible(false);
        }
        if(actionEvent.getSource()==showInventory)
        {
            AddProducts products = new AddProducts();
            inventory+=products.readProducts();
            performShowInventory();
        }
    }
}