package acc;

public class Menu {

	public static void main(String[] args) {
		Bank bank = new Bank();
		while(true) {
			int selected = bank.selectMenu();
			if(selected == 9) break;
			switch(selected) {
			case 1: bank.makeAccount();
			case 2: bank.deposit();
			case 3: bank.withdraw();
			case 4: bank.accountInfo();
			case 5: bank.allAccountInfo();;
			}
		}

	}

}
