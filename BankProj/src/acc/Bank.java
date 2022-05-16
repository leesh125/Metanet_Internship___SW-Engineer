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
	
	// ���°���
	public void makeAccount() {
		String id;
		System.out.println("[���°���]");
		while(true) {
			System.out.print("���¹�ȣ: ");
			id = sc.nextLine();
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
		System.out.print("[���� ��ȸ]");
		System.out.println(accounts.get(id).toString());
	}
	
	// ��� ���� ���
	public void allAccountInfo() {
		System.out.print("[��ü ���� ��ȸ]");
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
		System.out.println("9.����");
		System.out.print("����>> ");
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
