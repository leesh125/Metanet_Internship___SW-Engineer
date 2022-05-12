package emp;

public abstract class Employee {
	private String id;
	private String name;
		
	public Employee() {

	}

	public Employee(String id, String name) {
		this.id = id;
		this.name = name;
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

	public abstract int getPay();

	@Override
	public String toString() {
		return "사번: " + id + "\t이름: " + name;
	}
}
