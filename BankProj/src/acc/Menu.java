package acc;

import java.util.Scanner;

public class Menu {
	private static Scanner sc = new Scanner(System.in);
	private static String id;
	public static void main(String[] args) {
		Bank bank = new Bank();
		//bank.loadAccount_b();
		bank.loadAccount_t();
		while(true) {
			try {
				int selected = bank.selectMenu();
				if(selected == 9) break;
				switch(selected) {
				case 1: 
						bank.makeAccount();
						bank.saveAccount_t();
						break;
				case 2: 
					id = inputId();
					bank.deposit(id);
					break;
				case 3: 
					id = inputId();
					bank.withdraw(id);
					break;
				case 4: 
					id = inputId();
					bank.accountInfo(id);
					break;
				case 5: bank.allAccountInfo();;
						break;
				}
			}catch(NumberFormatException e) {
				System.out.println("입력 형식이 바르지 않습니다.");
			}
		}

	}
	
	private static String inputId() {
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		return id;
	}

}
