package acc;

import java.util.HashMap;
import java.util.Scanner;

public class Bank {
	Scanner sc = new Scanner(System.in);
	static int ACC_SIZE = 100;
	HashMap<String,Account> accounts = new HashMap<>(ACC_SIZE);
	
	// ���°���
	public void makeAccount() {
		System.out.println("[���°���]");
		System.out.print("���¹�ȣ: ");
		String id = sc.nextLine();
		while(true) {
			if(accounts.containsKey(id)) {
				System.out.println("�ߺ��� ���¹�ȣ �Դϴ�.");
				continue;
			}else {
				break;
			}
		}
		System.out.print("�̸�: ");
		String name = sc.nextLine();
		System.out.print("�Աݾ�: ");
		int balance = sc.nextInt(); sc.nextLine();
		
		if(accounts.size() == ACC_SIZE) {
			System.out.println("�˼��մϴ�.\n ���� ������ ���̻� �� �� �����ϴ�.");
			return;
		}else {
			Account newAcc = new Account(id,name,balance);
			accounts.put(id, newAcc);
			System.out.println("���°����� �Ϸ�Ǿ����ϴ�.");
		}
	}
	
	/* null�� ��ȯ�Ǹ� �ٽ� ���̵� ��ȸ�ϱ�!!! */
	private Account searchAccById(String id) { 
		if(!accounts.containsKey(id)) { // �ش� ���°� ���ٸ�
			System.out.println("�ش� ���°� �����ϴ�.");
			System.out.println("���� ������ �Ͻðڽ��ϱ�?");
			System.out.print("1.���°���\t2.���");
			int select = sc.nextInt(); sc.nextLine();
			
			if(select == 1) { // 1.���°��� ����
				makeAccount();
			}else { // 2.��� ����
				System.exit(-1);
			}
			return null;
		}else {
			return accounts.get(id);
		}
	}
	
	// �Ա��ϱ�
	public void deposit(String id) {
		System.out.print("�Ա��� �ݾ�: ");
		int money = sc.nextInt(); sc.nextLine();
		accounts.get(id).deposit(money);
	}

	// ����ϱ�
	public void withdraw(String id) {
		System.out.print("����� �ݾ�: ");
		int money = sc.nextInt(); sc.nextLine();
		accounts.get(id).withdraw(money);
	}

	// ���� ���� ��ȸ
	public void accountInfo(String id) {
		System.out.println(accounts.get(id).toString());
	}
	
	// ��� ���� ���
	public void allAccountInfo() {
		for(Account acc: accounts.values()) {
			System.out.println(acc.toString());
		}
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
