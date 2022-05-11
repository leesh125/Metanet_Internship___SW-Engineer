class Person {
	int age;
	String name;
	
	String info() {
		return "이름: "  + name + ", 나이: " + age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
public class ClassTest1 {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.age = 10;
		p1.name = "홍길동";
		Person p2 = new Person();
		p2.age = 20;
		p2.name = "김길동";
		System.out.println(p1.info());
		System.out.println(p2.info());
	}

}
