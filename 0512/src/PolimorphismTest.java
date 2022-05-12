class Person{
	int age;
	String name;
	
	public Person() {}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "�̸�: " + name + ", ����: " + age;
	}
}

class Student extends Person {
	String subject;

	public Student() {}

	public Student(int age, String name, String subject) {
		super(age,name);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", ����: " + getSubject();
	}
}
public class PolimorphismTest {

	public static void main(String[] args) {
		Person p = new Person(10, "hong");
		Student s = new Student(20, "gogo", "������");
		
		Person ps = new Student(30,"haha", "������");
		ps.setAge(15);
		System.out.println(ps.toString());
		// ps.getSubject();
		
		Student sp = (Student)ps; // down casting
		
	}

}
