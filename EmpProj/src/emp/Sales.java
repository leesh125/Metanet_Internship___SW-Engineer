package emp;

public class Sales extends Permanent implements IBusinessTrip{
	private int incentive;
	
	public Sales() {

	}
	
	public int getIncentive() {
		return incentive;
	}

	public void setIncentive(int incentive) {
		this.incentive = incentive;
	}

	public Sales(String id, String name, int pay, int incentive) {
		super(id, name, pay);
		this.incentive = incentive;
	}

	@Override
	public int getPay() {
		return super.getPay() + getIncentive();
	}
	
	@Override
	public void goBusinessTrip(int day) {
		setIncentive(day + incentive);
	}
}
