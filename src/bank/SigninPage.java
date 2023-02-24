package bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Stack;


public class SigninPage extends Account {

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

    public static String userSignin;
    public static String passSignin;

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


        //Signin Button
        signIn = new JButton("Sign In");
        signIn.setBounds(430,100, 100,20);
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
                panel.remove(SignupPage.accountCreatedLabel);
                userSignin = userNameField.getText();
                passSignin = passwordField.getText();
                JLabel incorrectPasswordUsername = new JLabel(" Incorrect Username and or Password");
                incorrectPasswordUsername.setBounds(375, 150, 700, 25);

                if(userAndAcc.containsKey(userSignin))
                {
                    String correctPassword = userAndAcc.get(userSignin).Password;

                    if(passSignin.equals(correctPassword))
                    {
                        panelContainer.add(Account.userAndAcc.get(userSignin).getUserPanel(),"4");
                        SignedIn.panel4();
                        cardLayout.show(panelContainer, "4");
                    }

                    else {
                        panel.repaint();
                        panel.add(incorrectPasswordUsername);
                    }
                }

                else {
                    panel.repaint();
                    panel.add(incorrectPasswordUsername);
                }
            }
        });

    }
    public static void frameAndContainer()
    {
        frame.setSize(1100,1000);
        frame.add(panelContainer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        panelContainer.setLayout(cardLayout);

        panelContainer.add(panel, "1");
        panelContainer.add(panel2, "2");
        panelContainer.add(panel3, "3");
        panelContainer.add(panel5, "5");
        panelContainer.add(SignedIn.withdrawPanel, "withdraw");
        panelContainer.add(SignedIn.depositPanel, "deposit");
        panelContainer.add(SignedIn.sendTransferPanel, "send");
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

            //Signup Button
        signupPage = new JButton("Sign Up");
        signupPage.setBounds(430,125,100,20);
        panel.add(signupPage);
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


    public static void main(String [] args)
    {
        Stack<JLabel> tranLog = new Stack<>();
        Account acc1 = new Account("m", "c","Montrell", "Campbell", "302 N School St", "mcamp10@ilstu.edu", tranLog);
        userAndAcc.put(acc1.UserName, acc1);
        acc1.balance += 500;

        Stack<JLabel> tranLog1 = new Stack<>();
        Account acc2 = new Account("b", "c","brandon", "Cunningham", "louisiana", "brandon@gmail.com", tranLog1);
        userAndAcc.put("b", acc2);
        acc2.balance += 500;


        panel1();

    }

}