package com.cg.main;

import com.cg.exception.InsufficientBalanceException;
import com.cg.exception.InsufficientInitialBalanceException;
import com.cg.exception.InvalidAccountNumberException;

public class BankClient {
	
	public static void main(String[] args) {
		ICICIBank bank = new ICICIBank();		
		
		try
		{
			System.out.println(bank.createAccount(101, 3000));
			System.out.println(bank.createAccount(102, 3000));
			
			System.out.println("Balance = "+bank.withdrawAmount(101, 4000));
			System.out.println("Deposite Amount " +bank.depositeAmount(101, 1500));
			
			System.out.println("Fund Transfer Amount " +bank.fundTransfer(101, 102, 1000));
			
		}catch(InvalidAccountNumberException i)
		{
			System.out.println("Invalid account number ");
		}
		catch(InsufficientBalanceException ibe){			
			System.out.println("Exception Occurs :"+ibe.getMessage());
		}
		catch (InsufficientInitialBalanceException e) {
			System.out.println("Insufficient Initial balance");
		}

	}
}
