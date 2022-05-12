package acc;

public class Account {
	private String id;
	private String name;
	private int balance;
	
	public Account() {}

	public Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
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
