import emp.Employee;
import emp.IBusinessTrip;
import emp.PartTime;
import emp.Permanent;
import emp.Sales;

public class Company {
	static final int EMP_COUNT = 10;
	static Employee[] employees = new Employee[EMP_COUNT];
	static int empCnt = 0;
	
	private void addEmployee(Employee emp) {
		employees[empCnt++] = emp;
	}


	private int allTotalPay() {
		int sum = 0, cnt = 0;
		for(Employee emp: employees) {
			if(emp != null) {
				sum += emp.getPay();
				cnt += 1;
			}
		}
		return sum / cnt;
	}
	
	public void regBusinessTrip(IBusinessTrip emp, int day) {
		
	}

	private void allEmpInfo() {
		for(Employee emp: employees) {
			if(emp != null) {
				System.out.println(emp.toString());				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Company com = new Company();
		Permanent emp1 = new Permanent("10001", "È«±æµ¿", 5000000);
		Sales emp2 = new Sales("10002", "±è±æµ¿", 30000, 3000);
		PartTime emp3 = new PartTime("10003", "°í±æµ¿", 160, 100000);
		com.addEmployee(emp1);  com.addEmployee(emp2);  com.addEmployee(emp3);
		
		// com.regBusinessTrip(emp1, 2); // error 
		com.regBusinessTrip(emp2, 2);
		com.regBusinessTrip(emp3, 2);
		
		com.allEmpInfo();
		System.out.println("ÃÑ ±Þ¿©¾×: " + com.allTotalPay());
	}

}
