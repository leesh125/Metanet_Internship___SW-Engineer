import java.io.Serializable;

public class Person implements Comparable<Person>, Serializable{
	int age;
	String name;
	
	Person() {
		this(0,"none");
	}
	
	Person(int age) {
		this(age,"none");
	}
	
	Person(String name) {
		this(0,name);
	}

	Person(int age, String name) {
		this.age = age;
		this.name = name;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age=age;
	}
	
	@Override
	public String toString() {
		return "이름:"+this.name+", 나이:"+this.age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person == false) {
			return false;
		}
		Person p = (Person)obj;
		return name.equals(p.getName()) && age==p.getAge();
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + age;
	}

	@Override
	public int compareTo(Person o) {
		return o.age - age;
	}
}