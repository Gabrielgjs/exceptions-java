package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class ProgramAccount {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int number = scan.nextInt();
		System.out.print("Holder: ");
		scan.nextLine();
		String holder = scan.next();
		System.out.print("Initial balance: ");
		double balance = scan.nextDouble();
		System.out.print("Withdraw limit: ");
		double withdrawLimit = scan.nextDouble();

		Account acc = new Account(number, holder, balance, withdrawLimit);

		System.out.print("Enter amount for withdraw: ");
		double amount = scan.nextDouble();

		try {
			acc.withdraw(amount);
			System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
		}

		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		scan.close();
	}

}
