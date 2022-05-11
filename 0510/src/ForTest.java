
public class ForTest {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		System.out.print(i + "부터 ");
		
//		for(i=1; i<=10; i++) {
//			sum += i;
//		}
//		System.out.println(i + "까지의 합: " + sum);

		/* for문 */
		for(i=1; ; i++) {
			sum += i;
			if(sum > 100) break;
		}
		System.out.println(i + "까지의 합: " + sum);
		
	}

}
