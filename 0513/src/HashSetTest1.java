import java.util.HashSet;

public class HashSetTest1 {
	public static void main(String[] args) {
		Integer n = 10; // boxing
		int n2 = n; // unboxing
		
		HashSet<Integer> hs = new HashSet<>();
		hs.add(1); hs.add(2); hs.add(1);
//		for(int n: hs) {
//			System.out.println(n);
//		}
		
		HashSet<Person> hsp = new HashSet<>();
		hsp.add(new Person(10,"ȫ�浿"));
		hsp.add(new Person(20,"��浿"));
		hsp.add(new Person(10,"�ڱ浿"));
		hsp.add(new Person(10,"ȫ�浿"));
		
		for(Person p: hsp) {
			System.out.println(p);
		}
	}

}
