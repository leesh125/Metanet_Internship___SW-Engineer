
public class StringTest {

	public static void main(String[] args) {
		String fruits = "apple,banana,orange";
		String[] fruit = fruits.split(",");
		for(String f : fruit) {
			System.out.println(f);
		}
	}

}
