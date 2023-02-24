package bank;

import javax.swing.*;
import java.util.*;

public class Account  {

    String firstName;

    String lastName;
    String Address;
    String UserName;
    String Password;
    Double balance;
    int accountNumber;
    String email;

    Stack <JLabel> transactionLog;

    public JPanel userPanel;

    public static Set <Account> accounts = new HashSet<>();

    public static HashMap<String, Account> userAndAcc = new HashMap<>();


    public Account()
    {
        accounts = new HashSet<>();
        userPanel = new JPanel();
        transactionLog = new Stack<>();
    }

    public Account(String userName, String password, String firstName, String lastName, String address, String email, Stack<JLabel> transactionLog)
    {

        this.UserName = userName;
        this.Password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = address;
        this.balance = 0.00;
        this.transactionLog = transactionLog;

        userPanel = new JPanel();

        Random rand = new Random();
        this.accountNumber = rand.nextInt(10000000) + 100000000;
    }

    public Account(String userName, String password)
    {

        this.UserName = userName;
        this.Password = password;

        firstName = new String();
        lastName = new String();
        Address = new String();

        transactionLog = new Stack<>();
        userPanel = new JPanel();

    }

    public void withdraw(double withdrawlAmount)
    {
        this.balance -= withdrawlAmount;
    }

    public void deposit(double depositAmount)
    {
        this.balance += depositAmount;
    }

    public void addTransaction(JLabel transactionType)
    {
        this.transactionLog.push(transactionType);
    }


    public JPanel getUserPanel()
    {
        return userPanel;
    }







}
