
public class ForTest {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		System.out.print(i + "���� ");
		
//		for(i=1; i<=10; i++) {
//			sum += i;
//		}
//		System.out.println(i + "������ ��: " + sum);

		/* for�� */
		for(i=1; ; i++) {
			sum += i;
			if(sum > 100) break;
		}
		System.out.println(i + "������ ��: " + sum);
		
	}

}
