package acc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Bank {
	Scanner sc = new Scanner(System.in);
	static int ACC_SIZE = 100;
	HashMap<String,Account> accounts = new HashMap<>(ACC_SIZE);
	
	// 계좌개설
	public void makeAccount() {
		String id;
		System.out.println("[계좌개설]");
		while(true) {
			System.out.print("계좌번호: ");
			id = sc.nextLine();
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
		System.out.print("[계좌 조회]");
		System.out.println(accounts.get(id).toString());
	}
	
	// 모든 계좌 출력
	public void allAccountInfo() {
		System.out.print("[전체 계좌 조회]");
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
		System.out.println("9.종료");
		System.out.print("선택>> ");
		int selected = Integer.parseInt(sc.nextLine());
		return selected;
	}
	
	public void saveAccount_b() {
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		try {
			fos = new FileOutputStream("accs.bin");
			dos = new DataOutputStream(fos);
			dos.writeInt(accounts.size());
			for(Account account: accounts.values()) {
				dos.writeUTF(account.getId());
				dos.writeUTF(account.getName());
				dos.writeInt(account.getBalance());
			}
		} catch(IOException e) {
			
		} finally {
			try {
				if(dos != null) dos.close();
			} catch(IOException e) {}
		}
	}
	
	public void loadAccount_b() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("accs.bin");
			dis = new DataInputStream(fis);
			int cnt = dis.readInt();
			for(int i=0; i<cnt; i++) {
				String id = dis.readUTF();
				String name = dis.readUTF();
				int balance = dis.readInt();
				accounts.put(id, new Account(id,name,balance));
			}
		} catch(IOException e) {
			
		} finally {
			try {
				if(dis != null) dis.close();
			}catch(IOException e) {}
		}
	}
	
	public void saveAccount_t() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter("accs.txt");
			bw = new BufferedWriter(fw);
			String accStr = "";
			for(Account account:accounts.values()) {
				accStr += account.getId();
				accStr += "#" + account.getName();
				accStr += "#" + account.getBalance();
				bw.write(accStr);
				bw.newLine();
			}
		}catch(IOException e) {
			
		} finally {
			try {
				if(bw != null) bw.close();
			}catch(IOException e) {}
		}
	}
	
	public void loadAccount_t() {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("accs.txt");
			br = new BufferedReader(fr);
			String accStr = null;
			while((accStr = br.readLine()) != null) {
				String[] accCol = accStr.split("#");
				accounts.put(accCol[0], new Account(accCol[0], accCol[1],
							Integer.parseInt(accCol[2])));
			}
		} catch(IOException e) {
			
		} finally {
			try {
				if(br != null) br.close();
			}catch(IOException e) {}
		}
	}
	
	public void saveAccount_o() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("accs.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeInt(accounts.size());
			for(Account acc : accounts.values()) {
				oos.writeObject(acc);
			}
		} catch(IOException e) {
			
		} finally {
			try {
				if(oos != null) oos.close();
			}catch(IOException e) {}
		}
	}
	
	public void loadAccount_o() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("accs.ser");
			ois = new ObjectInputStream(fis);
			int cnt = ois.readInt();
			for(int i=0; i<cnt; i++) {
				Account acc = (Account)ois.readObject();
				accounts.put(acc.getId(), acc);	
			}
		} catch(Exception e) {
			
		} finally {
			try {
				if(ois != null) ois.close();
			}catch(IOException e) {}
		}
	}
}
