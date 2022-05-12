interface IBusinessTrip {
	void goBusiness(int day);
}

//class Permanent implements IBusinessTrip {
//	@Override
//	public void goBusiness(int day) {
//		System.out.println(day + "�� ���尨");
//	}
//}

public class InterfaceTest3 {

	static void doBusinessTrip(IBusinessTrip emp, int day) {
		emp.goBusiness(day);
	}
	
	public static void main(String[] args) {
		IBusinessTrip emp = new IBusinessTrip() {
			@Override
			public void goBusiness(int day) {
				System.out.println(day + "�� ���尨");
			}
		};
		
		doBusinessTrip(emp, 3);

	}

}
