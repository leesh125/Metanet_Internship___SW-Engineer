class Person {
	int age;
	String name;
	
	Person() {
		this(0,"none");
//		this.age = 0;
//		this.name = "None";
	}
	
	public Person(int age) {
		this(age,"none");
//		this.age = age;
//		this.name = "None";
	}
	

	public Person(String name) {
		this(0,name);
//		this.name = name;
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	String info() {
		return "�̸�: "  + name + ", ����: " + age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
public class ClassTest1 {

	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person(20, "��浿");
		Person p3 = new Person(30);
		Person p4 = new Person("Ȧ�浿");
//		p1.age = 10;
//		p1.name = "ȫ�浿";
//		p2.name = "��浿";
//		p2.setAge(25);
		System.out.println(p1.info());
		System.out.println(p2.info());
		System.out.println(p3.info());
		System.out.println(p4.info());

	}

}
