package emp;

public class PartTime extends Employee{
	private int time;
	private int payPerTime;
	
	public PartTime() {
	
	}

	public PartTime(String id, String name,int time, int payPerTime) {
		super(id, name);
		this.time = time;
		this.payPerTime = payPerTime;
	}

	public int getPay() {
		return time * payPerTime;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t±Þ¿©: " + this.getPay();
	}
}
