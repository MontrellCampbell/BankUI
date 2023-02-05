package bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupPage extends SigninPage {

    public static void panel2()
    {
        JLabel title = new JLabel("SignUp");
        title.setBounds(460,10 , 80, 25);

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(280,50,80,25);

        JTextField firstNameField = new JTextField(20);
        firstNameField.setBounds(400, 50, 165, 25);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(280,80,80,25);

        JTextField lastNameField = new JTextField(20);
        lastNameField.setBounds(400, 80, 165, 25);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(280,110,80,25);

        JTextField addressField = new JTextField(20);
        addressField.setBounds(400, 110, 165, 25);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(280,180,100,25);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(400, 180, 165, 25);

        JLabel usernameLabel = new JLabel("User Name");
        usernameLabel.setBounds(280,210,100,25);

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(400, 210, 165, 25);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(280,240,100,25);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(400, 240, 165, 25);

        JLabel passwordConfirmLabel = new JLabel("Confirm Password");
        passwordConfirmLabel.setBounds(280,270,150,25);

        JPasswordField passwordConfirmField = new JPasswordField(20);
        passwordConfirmField.setBounds(400, 270, 165, 25);

        JLabel usernameRestrictionLabel = new JLabel("* Username must be at least 4 characters");
        usernameRestrictionLabel.setBounds(580,210,260,25);

        JLabel passwordRestrictionLabel = new JLabel("* Password must be at least 8 characters");
        passwordRestrictionLabel.setBounds(580,240,260,25);

        JButton signupButton = new JButton("Create Account");
        signupButton.setBounds(412,325, 140,20);
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = usernameField.getText();
                String pass = passwordField.getText();
                boolean criteriaNotMet = false;

                if(user.length() < 4)
                {
                    JLabel usernameInvalid = new JLabel("* Username Criteria Wasn't Met");
                    usernameInvalid.setBounds(280,380,260,25);
                    panel5.add(usernameInvalid);
                    criteriaNotMet = true;
                }
                if (pass.length() < 8)
                {
                    JLabel passWordInvalid = new JLabel("* Password Criteria Wasn't Met");
                    passWordInvalid.setBounds(280,400,260,25);
                    panel5.add(passWordInvalid);
                    criteriaNotMet = true;
                }

                if(criteriaNotMet == true)
                {
                    panel5();
                    cardLayout.show(panelContainer, "5");
                }


            }
        }
        );

        panel2.add(title);
        panel2.add(firstNameLabel);
        panel2.add(firstNameField);
        panel2.add(lastNameLabel);
        panel2.add(lastNameField);
        panel2.add(addressLabel);
        panel2.add(addressField);
        panel2.add(emailLabel);
        panel2.add(emailField);
        panel2.add(usernameField);
        panel2.add(usernameLabel);
        panel2.add(passwordLabel);
        panel2.add(passwordField);
        panel2.add(passwordConfirmLabel);
        panel2.add(passwordConfirmField);
        panel2.add(signupButton);
        panel2.add(usernameRestrictionLabel);
        panel2.add(passwordRestrictionLabel);

        panel2.setLayout(null);

        //cardLayout.show(panelContainer,"1");
    }

    public static void panel5()
    {

        JLabel title = new JLabel("SignUp");
        title.setBounds(460,10 , 80, 25);

        JLabel firstNameLabel = new JLabel("First Name");
        firstNameLabel.setBounds(280,50,80,25);

        JTextField firstNameField = new JTextField(20);
        firstNameField.setBounds(400, 50, 165, 25);

        JLabel lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setBounds(280,80,80,25);

        JTextField lastNameField = new JTextField(20);
        lastNameField.setBounds(400, 80, 165, 25);

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setBounds(280,110,80,25);

        JTextField addressField = new JTextField(20);
        addressField.setBounds(400, 110, 165, 25);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(280,180,100,25);

        JTextField emailField = new JTextField(20);
        emailField.setBounds(400, 180, 165, 25);

        JLabel usernameLabel = new JLabel("User Name");
        usernameLabel.setBounds(280,210,100,25);

        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(400, 210, 165, 25);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(280,240,100,25);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(400, 240, 165, 25);

        JLabel passwordConfirmLabel = new JLabel("Confirm Password");
        passwordConfirmLabel.setBounds(280,270,150,25);

        JPasswordField passwordConfirmField = new JPasswordField(20);
        passwordConfirmField.setBounds(400, 270, 165, 25);

        JButton signupButton = new JButton("Create Account");
        signupButton.setBounds(412,325, 140,20);

        panel5.add(title);
        panel5.add(firstNameLabel);
        panel5.add(firstNameField);
        panel5.add(lastNameLabel);
        panel5.add(lastNameField);
        panel2.add(addressLabel);
        panel5.add(addressField);
        panel5.add(emailLabel);
        panel5.add(emailField);
        panel5.add(usernameField);
        panel5.add(usernameLabel);
        panel5.add(passwordLabel);
        panel5.add(passwordField);
        panel5.add(passwordConfirmLabel);
        panel5.add(passwordConfirmField);
        panel5.add(signupButton);

        panel5.setLayout(null);



    }



}
