package acc;

public class Account {
	String id;
	String name;
	int balance;
	
	public Account() {}

	public Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "���¹�ȣ: " + this.id + ", �̸�: " + this.name + ", �ܾ�: " + this.balance;
	}
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public void withdraw(int balance){
        if(balance > this.balance) System.out.println("�ܾ� ����!");
        else this.balance -= balance;
    }
}
