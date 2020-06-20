import javax.swing.border.*;
import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class MainMenu implements ActionListener
{
    protected JFrame mainFrame = new JFrame();
    protected JPanel mainPanel = new JPanel();
    protected JButton signUp = new RoundButton("Sign Up");
    protected JButton signIn =new RoundButton("Sign In");
    protected JLabel welcomeLabel = new JLabel("<html><strong/><b/>Electronics Store: <br/> ",SwingConstants.CENTER);
    protected JLabel welcomeLabel2 = new JLabel("<html><br/><strong/><b/>management application</html>", SwingConstants.CENTER);
    public void performMain()
    {
        mainFrame.setSize(790,550);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.add(mainPanel);
        mainFrame.setLocationRelativeTo(null);
        mainPanel.setBackground( new Color(158,95,95));
        mainPanel.setLayout(null);
        //Signup
        signUp.setBounds(125,190,155,70);
        signUp.addActionListener(this);
        signUp.setBackground(new Color(104, 136, 225));
        mainPanel.add(signUp);
        //Signin
        signIn.setBounds(390,190,155,70);
        signIn.addActionListener(this);
        signIn.setBackground(new Color(104,136,225));
        mainPanel.add(signIn);
        //Label
        welcomeLabel.setFont(new Font("Serif",Font.PLAIN,40));
        welcomeLabel2.setFont(new Font("Serif",Font.PLAIN,40));
        welcomeLabel.setBounds(70,0,350,140);
        welcomeLabel2.setBounds(215,25,350,140);
        mainPanel.add(welcomeLabel);
        mainPanel.add(welcomeLabel2);
    }
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource()==signUp)
        {
            SignUp signup = new SignUp();
            signup.performAdmin();
            mainFrame.setVisible(false);
        }
        else
            if(actionEvent.getSource()==signIn)
            {
                SignIn signin = new SignIn();
                signin.performSignIn();
                mainFrame.setVisible(false);
            }
    }
}
 class RoundButton extends JButton {
    public RoundButton(String label) {
        super(label);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width,size.height);
        setPreferredSize(size);

        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width-1,getSize().height-1);

        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width-1,     getSize().height-1);
    }

    Shape shape;
    public boolean contains(int x, int y) {
        if (shape == null ||
                !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }
}

