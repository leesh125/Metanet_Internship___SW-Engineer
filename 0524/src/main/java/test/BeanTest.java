package test;

public class BeanTest {
	private String name;
	
	public BeanTest() {
		this.name = "홍길동";
	}

	public BeanTest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
