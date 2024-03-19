package com.example;

import java.util.HashSet;
import java.util.Objects;

public class Exercise02 {

	public static void main(String[] args) {
		var accounts = new HashSet<Account>();
		accounts.add(new Account("tr1", 1_000_000));
		accounts.add(new Account("tr2", 2_000_000));
		accounts.add(new Account("tr3", 3_000_000));
		// after a long lines of codes
		var exists = accounts.contains(new Account("tr2", 2_000_000));
		System.out.println(exists);
	}

}

class Account extends Object {
	private String iban;
	private double balance;

	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(iban);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(iban, other.iban);
	}


	
	
	

}