class Person {
	int age;
	String name;
	
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
		p1.age = 10;
		p1.name = "ȫ�浿";
		Person p2 = new Person();
		p2.age = 20;
		p2.name = "��浿";
		System.out.println(p1.info());
		System.out.println(p2.info());
	}

}
