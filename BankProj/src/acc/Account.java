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
		return "계좌번호: " + this.id + ", 이름: " + this.name + ", 잔액: " + this.balance;
	}
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public void withdraw(int balance){
        if(balance > this.balance) System.out.println("잔액 부족!");
        else this.balance -= balance;
    }
}
