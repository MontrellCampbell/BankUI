package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Stack;


public class SigninPage extends Account implements ActionListener {

    public static JTextField userNameField;
    public static JTextField passwordField;

    public static JLabel userNameLabel;

    public static JLabel passWordLabel;

    public static JButton signIn;

    public static JButton signupPage;

    public static JFrame frame = new JFrame();

    public static JPanel panelContainer = new JPanel();
    public static JPanel panel = new JPanel();

    public static JPanel panel2 = new JPanel();

    public static JPanel panel3 = new JPanel();

    public static JPanel panel5 = new JPanel();


    public static CardLayout cardLayout = new CardLayout();

    public static void panelLayout()
    {
        // Creating a Frame and a Panel
        frame = new JFrame();
        panel = new JPanel();

        // Setting up the Frame

        //Setting the set panel layout
        panel.setLayout(null);

        //Labels and TextFields
        userNameLabel = new JLabel("UserName");
        userNameLabel.setBounds(300,20,80,25);


        userNameField = new JTextField(20);
        userNameField.setBounds(400, 20, 165, 25);


        passWordLabel = new JLabel("Password");
        passWordLabel.setBounds(300,50,80,25);


        passwordField = new JPasswordField();
        passwordField.setBounds(400, 50, 165, 25);


        signIn = new JButton("Sign In");
        signIn.setBounds(430,100, 100,20);
        signIn.addActionListener(new SigninPage());

    }

    public static void frameAndContainer()
    {
        frame.setSize(1000,1000);
        frame.add(panelContainer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panelContainer.setLayout(cardLayout);

        panelContainer.add(panel, "1");
        panelContainer.add(panel2, "2");
        panelContainer.add(panel3, "3");
        panelContainer.add(SignedIn.panel4,"4");
        panelContainer.add(panel5, "5");
    }

    public static void panel1()
    {
        panelLayout();
        frameAndContainer();

        panel.add(userNameLabel);
        panel.add(userNameField);
        panel.add(passWordLabel);
        panel.add(passwordField);
        panel.add(signIn);

        signupPage = new JButton("Sign Up");
        signupPage.setBounds(430,125,100,20);
        signupPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SignupPage.panel2();
                cardLayout.show(panelContainer, "2");
            }
        });
        panel.add(signupPage);

        //cardLayout.show(panelContainer,"1");
    }

    public static void panel3()
    {
        panel3.add(userNameLabel);
        panel3.add(userNameField);
        panel3.add(passWordLabel);
        panel3.add(passwordField);
        panel3.add(signIn);

        panel3.setLayout(null);

        signupPage = new JButton("Sign Up");
        signupPage.setBounds(430,125,100,20);
        signupPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignupPage.panel2();
                cardLayout.show(panelContainer, "2");
            }
        });
        panel.add(signupPage);

        JLabel incorrectLogin = new JLabel("Incorrect Username and or Password");
        incorrectLogin.setBounds(380, 20, 300,300 );

        panel3.add(incorrectLogin);
        panel3.add(signupPage);

    }

    public static void main(String [] args)
    {
        panel1();



    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String user = userNameField.getText();
        String pass = passwordField.getText();

        if(userAndAcc.containsKey(user))
        {
            if(userAndAcc.get(user).Password.equals(pass))
            {
                SignedIn.panel4();
                cardLayout.show(panelContainer, "4");
            }
        }else
        {
            panel3();
            cardLayout.show(panelContainer, "3");
        }
    }

}