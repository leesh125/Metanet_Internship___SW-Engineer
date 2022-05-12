package acc;

import java.util.Scanner;

public class Menu {
	private static Scanner sc = new Scanner(System.in);
	private static String id;
	public static void main(String[] args) {
		Bank bank = new Bank();
		while(true) {
			int selected = bank.selectMenu();
			if(selected == 9) break;
			switch(selected) {
			case 1: bank.makeAccount();
			case 2: 
				id = inputId();
				bank.deposit(id);
			case 3: 
				id = inputId();
				bank.withdraw(id);
			case 4: 
				id = inputId();
				bank.accountInfo(id);
			case 5: bank.allAccountInfo();;
			}
		}

	}
	
	private static String inputId() {
		System.out.print("°èÁÂ¹øÈ£: ");
		String id = sc.nextLine();
		return id;
	}

}
