import emp.Employee;
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

	private void allEmpInfo() {
		for(Employee emp: employees) {
			if(emp != null) {
				System.out.println(emp.toString());				
			}
		}
		
	}
	
	public static void main(String[] args) {
		Company com = new Company();
		com.addEmployee(new Permanent("10001", "È«±æµ¿", 5000000));
		com.addEmployee(new Sales("10002", "±è±æµ¿", 30000, 3000));
		com.addEmployee(new PartTime("10003", "°í±æµ¿", 160, 100000));
		
		com.allEmpInfo();
		System.out.println("ÃÑ ±Þ¿©¾×: " + com.allTotalPay());
	}

}
