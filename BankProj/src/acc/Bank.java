package acc;

import java.util.HashMap;
import java.util.Scanner;

public class Bank {
	Scanner sc = new Scanner(System.in);
	HashMap<String,Account> accounts = new HashMap<>(100);
	int cnt;
	
	public void makeAccount() {
		System.out.println("[계좌개설]");
		String id = sc.nextLine();
		if(accounts.containsKey(id)) {
			System.out.println("중복된 계좌번호 입니다.");
			
		}else {
			
		}
	}
	
	public void deposit() {
		
	}

	public void withdraw() {
		
	}

	public void accountInfo() {
		
	}

	public void allAccountInfo() {
		
	}
	
	public int selectMenu() {
		System.out.println("[메타은행]");
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.계좌조회");
		System.out.println("5.전체 계좌조회");
		System.out.println("9.전체 계좌조회");
		System.out.print("선택>> ");
		int selected = Integer.parseInt(sc.nextLine());
		return selected;
	}

}
