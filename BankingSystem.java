package project;

import java.util.Scanner;

public class BankingSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the customer's name: ");
		String customerName = sc.nextLine();
		System.out.println("Enter the customer's ID: ");
		String customerId = sc.nextLine();
		BankAccount user = new BankAccount(customerName,customerId);
		user.showMenu();
	}

}


class BankAccount
{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname, String cid)
	{
		customerName = cname;
		customerId = cid;
	}
	
	void deposit(int amount)     // method to calculate the balance after money deposit
	{
		if(amount!=0)
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount)    // method to calculate the balance after money withdraw
	{
		if(amount!=0)
		{
			balance = balance - amount;
			previousTransaction = -amount;   //to indicate withdraw a negative sign is inserted
		}
	}
	
	void getPreviousTransaction()
	{
		if(previousTransaction > 0)
		{
			System.out.println("Deposited: " + previousTransaction);
		}
		
		else if(previousTransaction < 0)
		{
			System.out.println("Withdraw: "+Math.abs(previousTransaction));
		}
		
		else
		{
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu()
	{
		char option = '\0';
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Welcome "+customerName);
		System.out.println("Your ID is "+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. EXIT");
		
		do
		{
			System.out.println("======================================================================================================");
			System.out.println("Enter an option :");
			System.out.println("======================================================================================================");
			option = s.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			
			case 'A':
				System.out.println("----------------------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("----------------------------------------");
				System.out.println("\n");
				break;
				
			case 'B':
				System.out.println("----------------------------------------");
				System.out.println("Enter the amount you want to deposit: ");
				System.out.println("----------------------------------------");
				int amount = s.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("----------------------------------------");
				System.out.println("Enter the amount you want to withdraw: ");
				System.out.println("----------------------------------------");
				int amount2 = s.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("----------------------------------------");
				getPreviousTransaction();
				System.out.println("----------------------------------------");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("**************************************************");
				break;
			
			default:
				System.out.println("Invalid Option!! Please enter again");
				break;
			}
		}while(option != 'E');
		
		System.out.println("Thank  You for using our services");
	}
}