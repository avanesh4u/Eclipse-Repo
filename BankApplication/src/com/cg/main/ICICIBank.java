package com.cg.main;

import java.util.LinkedList;

import com.cg.exception.InsufficientBalanceException;
import com.cg.exception.InsufficientInitialBalanceException;
import com.cg.exception.InvalidAccountNumberException;
import com.cg.model.Account;

public class ICICIBank {

LinkedList<Account> accounts=new LinkedList<>();
	
	
	public String createAccount(int accountNumber,int amount) throws InsufficientInitialBalanceException
	{
		if(amount<500)
			throw new InsufficientInitialBalanceException();
			
		Account account = new Account(accountNumber,amount);
		
		accounts.add(account);
		
		return "account created successfully";
	}
	
	private Account searchAccount(int accountNumber)throws InvalidAccountNumberException
	{
		
		for(Account account : accounts)
		{
			if(account.getAccountNumber()==accountNumber)
			{
				return account;
			}
		}
		throw new InvalidAccountNumberException();
		
	}
	
	public int withdrawAmount(int accountNumber,int amount) throws InvalidAccountNumberException, InsufficientBalanceException
	{
		Account account=searchAccount(accountNumber);
		
		if((account.getAmount()-amount)>=0)
		{
			account.setAmount(account.getAmount()-amount);
			return account.getAmount();
		}
		
		throw new InsufficientBalanceException("Insufficient Balance");
	}

	public int depositeAmount(int accountNumber, int amount) throws InvalidAccountNumberException {
		
		Account account=searchAccount(accountNumber);		
		
		account.setAmount(account.getAmount()+amount);
		
		return account.getAmount();
	}

	public String fundTransfer(int fromAccountNumber, int toAccountNumber, int amount) throws InvalidAccountNumberException {
		
		Account fromAccount = searchAccount(fromAccountNumber);
		
			fromAccount.setAmount(fromAccount.getAmount()-amount);
		
		Account toAccount =searchAccount(toAccountNumber);
		
			toAccount.setAmount(toAccount.getAmount()+amount);
		
		
		
		return fromAccount.getAmount()+" - "+toAccount.getAmount();
	}
	
}
