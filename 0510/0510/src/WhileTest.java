
public class WhileTest {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		System.out.print(i + "부터 ");

		/* while문 */
		while(sum < 100) {
			sum += i;
			i++;
		}
		System.out.println(i-1 + "까지의 합: " + sum);

	}

}
