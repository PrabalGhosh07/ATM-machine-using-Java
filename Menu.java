package peoject1;

import java.util.*;
import java.util.Map.Entry;
import java.text.DecimalFormat;
import java.io.*;

public class Menu extends Account{
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer,Integer>data = new HashMap<Integer,Integer>();
	int selection;
	
	/* Validate login information customer number and pin number */
	public void getLogin() throws IOException {
		int x=1;
		do {
			try {
				data.put(70630239, 1234);
				data.put(75869163, 4321);
				
				System.out.println("Welcome to the ATM !");
				
				System.out.println("Enter your customer Number : ");
				setCustomerNumber(menuInput.nextInt());
				
				System.out.println("Enter your Pin Number : ");
				setPinNumber(menuInput.nextInt());
			}
			catch(Exception e) {
				//If user type character --->
				System.out.println("\n" + "Invalid Character(s). Only numbers." + "\n");
				x=2;
			}
			for(Entry<Integer, Integer> entry : data.entrySet()) {
				if(entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
					getAccountType();
				}
				
			}
			System.out.println("\n" + "Wrong Customer Number or Pin Number. " + "\n");	
			
		}while(x==1);
	}
	
	// Display Account Type Menu With Selection----
	
	public void getAccountType() {
		System.out.println("Select the Account you want to Access :");
		System.out.println("Type 1 - Checking Account ");
		System.out.println("Type 2 - Saving Account ");
		System.out.println("Type 3 - Exit ");
		System.out.println("Choice : ");
		
		selection = menuInput.nextInt();
		
		switch (selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("Thank you for using this ATM, Have a nice Day. ");
			break;
		default :
			System.out.println("\n" + "Invalid Choice" + "\n");
			getAccountType();
		}
	}
	
	//Display Checking Account Menu with Selection ------>
	public void getChecking() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance ");
		System.out.println("Type 2 - Withdraw Funds ");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice : ");
		
		selection = menuInput.nextInt();
		
		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance: "+ moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, Have a nice Day. ");
			getAccountType();
			break;
		default :
			System.out.println("\n" + " Invalid Choice" + "\n");
		}
	}
	
	//Display Saving Account Menu with Selection ------>
	public void getSaving() {
		System.out.println("Checking Account: ");
		System.out.println("Type 1 - View Balance ");
		System.out.println("Type 2 - Withdraw Funds ");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.println("Choice : ");
		
		selection = menuInput.nextInt();
		
		switch (selection) {
		case 1:
			System.out.println("Checking Account Balance: "+ moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getSavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, Have a nice Day. ");
			getAccountType();
			break;
		default :
			System.out.println("\n" + " Invalid Choice" + "\n");
		}
	}
		
}
