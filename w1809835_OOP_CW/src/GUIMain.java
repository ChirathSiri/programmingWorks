import input.GUIInputHandler;
import input.view.GUI;
import manager.ChampionshipManager;
import manager.Formula1ChampionshipManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;


class GUIMain extends JFrame {

    ChampionshipManager championshipManager = new Formula1ChampionshipManager();
    GUI gui = new GUI( championshipManager );
    //main() method start
    public static void main(String arg[])
    {
        try
        {
            //create instance of the CreateLoginForm
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(500,500);  //set size of the frame
            form.setBounds(60,60,500,500);
            form.setVisible(true);  //make form visible to the user
        }
        catch(Exception e)
        {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

//create CreateLoginForm class to create login form
class CreateLoginForm extends JFrame implements ActionListener
{


    //initialize button, panel, label, and text field
    private JButton button;
    private JButton resetButton;
    private JCheckBox showPassword;
    private JPanel newPanel,imagePanel,imagePanel2;
    private JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;

    //calling constructor
    CreateLoginForm() {

        //create label for username
        userLabel = new JLabel();
        userLabel.setText("Admin Username");      //textField1

        //create text field to get username from the user
        textField1 = new JTextField(15);    //set length of the text

        //create label for password
        passLabel = new JLabel();
        passLabel.setText("Admin Password");      //set label value for textField2

        //create text field to get password from the user
        textField2 = new JPasswordField(15);    //set length for the password

        //create submit button
        button= new JButton("SUBMIT"); //set label to button

        resetButton = new JButton("RESET");

        showPassword = new JCheckBox("Show Password");

        Color n1= new Color(105,105,105);

        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(5, 1));
        newPanel.setBounds(10,10,400,800);
        imagePanel = new JPanel(new GridLayout(1,1));
        newPanel.add(imagePanel);

        imagePanel2 = new JPanel(new GridLayout(1,1));
        newPanel.add(imagePanel2);

        ImageIcon newImage = new ImageIcon("./Image/image.png");
        JLabel picLabel = new JLabel(newImage);
        picLabel.setSize(200,300);
        ImageIcon newImage2 = new ImageIcon("./Image/image2.png");
        JLabel picLabel2 = new JLabel(newImage2);
        picLabel2.setSize(200,300);
        imagePanel.setBounds(20,20,200,600);
        imagePanel.add(picLabel);
        imagePanel2.setBounds(20,20,200,600);
        imagePanel2.add(picLabel2);


        newPanel.setBackground(n1);

        newPanel.add(userLabel);    //set username label to panel
        newPanel.add(textField1);   //set text field to panel
        newPanel.add(passLabel);    //set password label to panel
        newPanel.add(textField2);   //set text field to panel
        newPanel.add(button);           //set button to panel
        newPanel.add(resetButton);
        newPanel.add(showPassword);

        userLabel.setBounds(50, 150, 100, 30);
        passLabel.setBounds(50, 220, 100, 30);
        textField1.setBounds(150, 150, 150, 30);
        textField2.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        button.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);

        //set border to panel
        add(newPanel, BorderLayout.CENTER);

        //perform action on button click
        button.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        setTitle("FORMULA 1 CHAMPIONSHIP MANAGER LOGIN PAGE");//title
    }


    //define abstract method actionPerformed()
    public void actionPerformed(ActionEvent ae)     //pass action
     {

        String userValue = textField1.getText();        //get user entered username
        String passValue = textField2.getText();        //get user entered password
         if (ae.getSource() == resetButton) {
             textField1.setText("");
             textField2.setText("");
         }
         //Coding Part of showPassword JCheckBox
         else if (ae.getSource() == showPassword) {
             if (showPassword.isSelected()) {
                 textField2.getText();
                 textField2.setVisible(true);
             } else {
                 textField2.getText();
                 textField2.setVisible(false);

             }
         }
        //check whether the credentials are authentic or not
        else if (userValue.equals("admin") && passValue.equals("admin")) {

            //create instance of the GuiMain
            GUIMain page = new GUIMain();

            //make page visible to the user
            page.setVisible(true);

            //create a welcome label and set it to the new page
            JFrame ne = new JFrame();
            //make page visible to the user
            JOptionPane.showMessageDialog(ne, "Welcome To The Formula 1  ChampionShip Manger! - " + userValue);
            JLabel wel_label = new JLabel("Welcome To The Formula 1  ChampionShip Manger: " + userValue);
            wel_label.setSize(400, 400);
            page.getContentPane().add(wel_label);
            //Coding Part of RESET button
        }

        else{
            //show error message
            JFrame ne= new JFrame();
            //make page visible to the user
            JOptionPane.showMessageDialog(ne, "Please enter valid username and password!");
            System.out.println("Please enter valid username and password");
        }
    }
}




