package emp;

public class PartTime extends Employee implements IBusinessTrip{
	private int time;
	private int payPerTime;
	
	public PartTime() {
	
	}

	public PartTime(String id, String name,int time, int payPerTime) {
		super(id, name);
		this.time = time;
		this.payPerTime = payPerTime;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getPayPerTime() {
		return payPerTime;
	}

	public void setPayPerTime(int payPerTime) {
		this.payPerTime = payPerTime;
	}

	public int getPay() {
		return time * payPerTime;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t±Þ¿©: " + this.getPay();
	}

	@Override
	public void goBusinessTrip(int day) {
		setTime(time + day * 24);
	}
}
