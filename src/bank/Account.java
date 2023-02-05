package bank;

import java.util.*;

public class Account {

    String firstName;

    String lastName;
    String Address;
    String UserName;
    String Password;
    Double balance;
    int accountNumber;

    Stack <String> transactionLog;

    public static Set <Account> accounts;

    public static HashMap<String, Account> userAndAcc;


    public Account()
    {
        accounts = new HashSet<>();
        userAndAcc = new HashMap<>();
    }

    public Account(String userName, String password)
    {
        firstName = new String();
        lastName = new String();
        Address = new String();
        this.UserName = userName;
        this.Password = password;
        transactionLog = new Stack<>();
        userAndAcc = new HashMap<>();


    }

    public void addAccountToDataBase(Account newAcc)
    {
        accounts.add(newAcc);
    }





}
