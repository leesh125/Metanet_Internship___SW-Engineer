import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest1 {

	public static void main(String[] args) {
		TreeSet<Person> ts = new TreeSet<>();
		ts.add(new Person(30, "홍길동"));
		ts.add(new Person(20, "고길동"));
		ts.add(new Person(10, "박길동"));

		for(Person p:ts) {
			System.out.println(p);
		}
		
		TreeSet<Person> tsn = new TreeSet<>(new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				int ret = o1.getName().compareTo(o2.getName());
				if(ret == 0) {
					return o1.getAge() - o2.getAge();
				}else {
					return ret;
				}
				
			}
		});
		tsn.add(new Person(30, "홍길동"));
		tsn.add(new Person(20, "고길동"));
		tsn.add(new Person(10, "박길동"));
		
		for(Person p: tsn) {
			System.out.println(p);
		}
	}

}
