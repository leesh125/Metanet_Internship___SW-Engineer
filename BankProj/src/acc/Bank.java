package acc;

import java.util.HashMap;
import java.util.Scanner;

public class Bank {
	Scanner sc = new Scanner(System.in);
	HashMap<String,Account> accounts = new HashMap<>(100);
	int cnt;
	
	public void makeAccount() {
		System.out.println("[���°���]");
		String id = sc.nextLine();
		if(accounts.containsKey(id)) {
			System.out.println("�ߺ��� ���¹�ȣ �Դϴ�.");
			
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
		System.out.println("[��Ÿ����]");
		System.out.println("1.���°���");
		System.out.println("2.�Ա�");
		System.out.println("3.���");
		System.out.println("4.������ȸ");
		System.out.println("5.��ü ������ȸ");
		System.out.println("9.��ü ������ȸ");
		System.out.print("����>> ");
		int selected = Integer.parseInt(sc.nextLine());
		return selected;
	}

}
