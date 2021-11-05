package com;

import java.util.Scanner;

public class Account {

	int balance;
	int prevTransaction;
	String customerName;
	String customerId;

	Account(String cname, String cid){
		customerName = cname;
		customerId = cid;
	}

	// Deposit function
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			prevTransaction = amount;
		}

	}
	
	// Withdraw function
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			prevTransaction = -amount;
		}
		
	}
	
	// Previous transaction function
	void getPrevTransaction() {
		if(prevTransaction > 0) {
			System.out.println("Deposited: " + prevTransaction);
		} else if (prevTransaction < 0){
			System.out.println("Withdrew: " + Math.abs(prevTransaction));
		} else {
			System.out.println("No transaction occured");
		}
		
		
	}

	// Interest calculation
	void calculateInterest(int years) {
		double interestRate = .0185;
		double newBalance = (balance * interestRate * years) + balance;
		System.out.println("The current interest rate is " + (100 * interestRate) + "%");
		System.out.println("After " + years + " years, your balance will be: " + newBalance);
	}

	
	// Menu function
	void showMenu() {
		char option = '\0'; //placeholder
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerId);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A- Check balance");
		System.out.println("B- Make a deposit");
		System.out.println("C- Make a withdrawal");
		System.out.println("D- View previous transaction");
		System.out.println("E- Calaculate interest");
		System.out.println("F- Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = sc.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			case 'A':
				System.out.println("=====================");
				System.out.println("Balance = £" + balance);
				System.out.println("=====================");
				System.out.println();
				break;
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println();
				break;
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = sc.nextInt();
				withdraw(amount2);
				System.out.println();
			case 'D':
				System.out.println("=====================");
				getPrevTransaction();
				System.out.println("=====================");
				break;
			case 'E':
				System.out.println("Enter how many years of accrued interest: ");
				int years = sc.nextInt();
				calculateInterest(years);
				break;
			case 'F':
				System.out.println("=====================");
				break;
			default:
				System.out.println("Error: Invalid option.");
				break;
				}
			} while(option != 'F');
		System.out.println("Thank you for banking with us!");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
