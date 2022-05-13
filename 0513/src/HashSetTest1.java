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
		hsp.add(new Person(10,"È«±æµ¿"));
		hsp.add(new Person(20,"±è±æµ¿"));
		hsp.add(new Person(10,"¹Ú±æµ¿"));
		hsp.add(new Person(10,"È«±æµ¿"));
		
		for(Person p: hsp) {
			System.out.println(p);
		}
	}

}
