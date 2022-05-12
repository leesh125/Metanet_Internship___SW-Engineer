package acc;

import java.util.HashMap;
import java.util.Scanner;

public class Bank {
	Scanner sc = new Scanner(System.in);
	static int ACC_SIZE = 100;
	HashMap<String,Account> accounts = new HashMap<>(ACC_SIZE);
	
	// 계좌개설
	public void makeAccount() {
		System.out.println("[계좌개설]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		while(true) {
			if(accounts.containsKey(id)) {
				System.out.println("중복된 계좌번호 입니다.");
				continue;
			}else {
				break;
			}
		}
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("입금액: ");
		int balance = sc.nextInt(); sc.nextLine();
		
		if(accounts.size() == ACC_SIZE) {
			System.out.println("죄송합니다.\n 계좌 개설을 더이상 할 수 없습니다.");
			return;
		}else {
			Account newAcc = new Account(id,name,balance);
			accounts.put(id, newAcc);
			System.out.println("계좌개설이 완료되었습니다.");
		}
	}
	
	/* null이 반환되면 다시 아이디 조회하기!!! */
	private Account searchAccById(String id) { 
		if(!accounts.containsKey(id)) { // 해당 계좌가 없다면
			System.out.println("해당 계좌가 없습니다.");
			System.out.println("계좌 개설을 하시겠습니까?");
			System.out.print("1.계좌개설\t2.취소");
			int select = sc.nextInt(); sc.nextLine();
			
			if(select == 1) { // 1.계좌개설 선택
				makeAccount();
			}else { // 2.취소 선택
				System.exit(-1);
			}
			return null;
		}else {
			return accounts.get(id);
		}
	}
	
	// 입금하기
	public void deposit(String id) {
		System.out.print("입급할 금액: ");
		int money = sc.nextInt(); sc.nextLine();
		accounts.get(id).deposit(money);
	}

	// 출금하기
	public void withdraw(String id) {
		System.out.print("출금할 금액: ");
		int money = sc.nextInt(); sc.nextLine();
		accounts.get(id).withdraw(money);
	}

	// 계좌 정보 조회
	public void accountInfo(String id) {
		System.out.println(accounts.get(id).toString());
	}
	
	// 모든 계좌 출력
	public void allAccountInfo() {
		for(Account acc: accounts.values()) {
			System.out.println(acc.toString());
		}
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
