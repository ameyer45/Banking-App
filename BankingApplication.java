//Inspired by https://youtu.be/wQbEH4tVMJA

import java.util.Scanner;

public class BankingApplication {
    public static void main(final String[] args) {
        final BankAccount obj1 = new BankAccount("Miranda", "0112");
        obj1.showMenu();
    }
}
class BankAccount{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(final String cName, final String cId){
        customerName = cName;
        customerId = cId;
    }
    
    void deposit(int amount){
        if(amount>0){
        balance+=amount;
        previousTransaction = amount;
        System.out.println("\n$" + amount+" has been desposited, your new balance is $"+balance);
        }
    }
    void getPrevT(){
        if(previousTransaction>0){
            System.out.println("Deposited : "+previousTransaction);
        }else{
            System.out.println("Withdrew : "+previousTransaction);
        }
        
    }

    void withdraw(final int amount){
        if(amount>balance){
            System.out.println("You don't have enough funds to support this transaction");
        }else{
            balance-=amount;
            previousTransaction = amount;
            System.out.println("\nA withdrawl for $"+ amount+ " has been made, your new balance is $"+ balance);
        }
    }
    void bal(){
        System.out.println("Your balance is $"+balance);
    
}
   

    void showMenu()
    {

        char option='\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nWelcome " + customerName);
        System.out.println("Your Id is "+ customerId);
        System.out.println("\n");
        
    
    do{
        System.out.println("\n=========================");
        System.out.println("Please Choose an Option:");
        System.out.println("\nA. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");
        System.out.println("=========================");
        option = scanner.next().charAt(0);
        System.out.println("\n");

        switch(option){
            case 'A':
            System.out.println("--------------------");
            bal();
            System.out.println("--------------------");
            break;

            case 'B':
            System.out.println("--------------------");
            System.out.println("How much would you like to deposit? ");
            final int amount = scanner.nextInt();
            deposit(amount);
            System.out.println("--------------------");
            break;

            case 'C':
            System.out.println("--------------------");
            System.out.println("How much would you like to withdraw? ");
            final int amount1 = scanner.nextInt();
            withdraw(amount1);
            System.out.println("--------------------");
            break;

            case 'D':
            System.out.println("--------------------");
            getPrevT();
            System.out.println("--------------------");
            break;

            case 'E':
            System.out.println("**************************");
            break;

            default:
            System.out.println("Invalid option, please enter again...");
            break;

        }
    
    }while(option != 'E');
    scanner.close();
    System.out.println("Thank you for using our services\n\n\n");
    }
}
