package bank;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupPage extends SigninPage {

        public static JLabel fNameInvalid = new JLabel("* This Field Cannot Be Empty");;
        public static JLabel lNameInvalid = new JLabel("* This Field Cannot Be Empty");
        public static JLabel emailInvalid = new JLabel("* Invalid Email Format");
        public static JLabel passWordInvalid = new JLabel("* Password Criteria Wasn't Met (Password must be at least 8 characters)");
        public static JLabel passNoMatch = new JLabel("* Passwords Do Not Match");

        public static  JLabel usernameInvalid = new JLabel("* Username Criteria Wasn't Met (Username must be at least 4 characters)");

        public static JLabel usernameRestrictionLabel = new JLabel("* Username must be at least 4 characters");

        public static JLabel passwordRestrictionLabel = new JLabel("* Password must be at least 8 characters");

        public static int labelsSet = 0;

        public static boolean restrictionLabelsActive = true;
        public static JLabel accountCreatedLabel = new JLabel("");

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


        if(restrictionLabelsActive == true) {
            usernameRestrictionLabel = new JLabel("* Username must be at least 4 characters");
            usernameRestrictionLabel.setBounds(580, 210, 260, 25);

            passwordRestrictionLabel = new JLabel("* Password must be at least 8 characters");
            passwordRestrictionLabel.setBounds(580, 240, 260, 25);
            restrictionLabelsActive = false;
        }

        JButton backToSignIn = new JButton("Back");
        backToSignIn.setBounds(412,350, 140,20);
        backToSignIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cardLayout.show(panelContainer, "1");
                fNameInvalid.setText("");
                lNameInvalid.setText("");
                emailInvalid.setText("");
                usernameInvalid.setText("");
                passWordInvalid.setText("");
                passNoMatch.setText("");

                firstNameField.setText("");
                lastNameField.setText("");
                addressField.setText("");
                emailField.setText("");
                usernameField.setText("");
                passwordField.setText("");
                passwordConfirmField.setText("");
            }
        });

        JButton signupButton = new JButton("Create Account");
        signupButton.setBounds(412,325, 140,20);
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String fName = firstNameField.getText();
                String lName = lastNameField.getText();
                String add = addressField.getText();
                String email = emailField.getText();
                String user = usernameField.getText();
                String pass = passwordField.getText();
                String passConfirm = passwordConfirmField.getText();


                boolean criteriaNotMet = false;

                String regex = "^(.+)@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher((CharSequence) email);

                if (fName.isEmpty()) {
                    fNameInvalid.setBounds(580, 50, 700, 25);
                    fNameInvalid.setText("* This Field Cannot Be Empty");
                    panel2.add(fNameInvalid);
                    criteriaNotMet = true;
                } else {
                    fNameInvalid.setText("");
                }

                if (lName.isEmpty()) {
                    lNameInvalid.setBounds(580, 80, 700, 25);
                    lNameInvalid.setText("* This Field Cannot Be Empty");
                    panel2.add(lNameInvalid);
                    criteriaNotMet = true;
                } else {
                    lNameInvalid.setText("");
                }

                if (!matcher.matches()) {
                    emailInvalid.setBounds(580, 180, 700, 25);
                    emailInvalid.setText("* Invalid Email Format");
                    panel2.add(emailInvalid);
                    criteriaNotMet = true;

                } else {
                    emailInvalid.setText("");
                }

                if (user.length() < 4) {
                    usernameInvalid.setBounds(580, 210, 700, 25);
                    usernameInvalid.setText("* Username Criteria Wasn't Met (Username must be at least 4 characters)");
                    panel2.add(usernameInvalid);
                    criteriaNotMet = true;
                }
                else {
                    if(userAndAcc.size() < 1)
                    {
                        if (userAndAcc.containsKey(user))
                        {
                            usernameInvalid.setBounds(580, 210, 700, 25);
                            usernameInvalid.setText("* Username Already in Use !");
                            panel2.add(usernameInvalid);
                            criteriaNotMet = true;
                        }
                    }
                    else {
                        usernameInvalid.setText("");
                    }
                }

                if (pass.length() < 8) {
                    passWordInvalid.setBounds(580, 240, 700, 25);
                    panel2.add(passWordInvalid);
                    passWordInvalid.setText("* Password Criteria Wasn't Met (Password must be at least 8 characters)");
                    criteriaNotMet = true;
                } else {
                    passWordInvalid.setText("");
                }

                if (!pass.equals(passConfirm)) {
                    passNoMatch.setBounds(580, 270, 700, 25);
                    passNoMatch.setText("* Passwords Do Not Match");
                    panel2.add(passNoMatch);
                    criteriaNotMet = true;
                } else {
                    passNoMatch.setText("");
                }

                panel2.remove(passwordRestrictionLabel);
                panel2.remove(usernameRestrictionLabel);

                if (criteriaNotMet == true) {
                    panel2.repaint();
                    panel2.remove(passwordRestrictionLabel);
                    panel2.remove(usernameRestrictionLabel);
                    cardLayout.show(panelContainer, "2");
                } else {
                    // 2/7/2023

                    String emailText = emailField.getText();
                    String address = addressField.getText();
                    Stack<JLabel> newAccTranLog = new Stack<>();
                    Account newAccount = new Account(user, pass, fName, lName, address, emailText, newAccTranLog);
                    accounts.add(newAccount);
                    userAndAcc.put(user, newAccount);
                    cardLayout.show(panelContainer, "1");
                    firstNameField.setText("");
                    lastNameField.setText("");
                    addressField.setText("");
                    emailField.setText("");
                    usernameField.setText("");
                    passwordField.setText("");
                    passwordConfirmField.setText("");

                    accountCreatedLabel = new JLabel("Account Created!");
                    accountCreatedLabel.setBounds(438, 215, 700, 25);
                    panel.add(accountCreatedLabel);
                    panel.repaint();
                }
            }

        }
        );

        if(labelsSet == 0) {
            labelsSet++;
            panel2.add(title);
            panel2.add(firstNameLabel);
            panel2.add(lastNameLabel);
            panel2.add(addressLabel);
            panel2.add(emailLabel);
            panel2.add(usernameLabel);
            panel2.add(passwordLabel);
            panel2.add(passwordConfirmLabel);
        }

        panel2.add(firstNameField);
        panel2.add(lastNameField);
        panel2.add(addressField);
        panel2.add(emailField);
        panel2.add(usernameField);
        panel2.add(passwordField);
        panel2.add(passwordConfirmField);
        panel2.add(signupButton);
        panel2.add(backToSignIn);
        panel2.add(usernameRestrictionLabel);
        panel2.add(passwordRestrictionLabel);

        panel2.setLayout(null);

        //cardLayout.show(panelContainer,"1");
    }



}
