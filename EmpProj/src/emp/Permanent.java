package emp;

public class Permanent extends Employee{
	private int pay;
	
	public Permanent() {
	
	}
	
	public Permanent(String id, String name, int pay) {
		super(id,name);
		this.pay = pay;
	}
	
	public Permanent(int pay) {
		super();
		this.pay = pay;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}


	@Override
	public String toString() {
		return super.toString() + "\t±Ş¿©: " + getPay();
	}
}
