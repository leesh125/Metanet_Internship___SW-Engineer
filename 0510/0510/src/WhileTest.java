
public class WhileTest {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		System.out.print(i + "���� ");

		/* while�� */
		while(sum < 100) {
			sum += i;
			i++;
		}
		System.out.println(i-1 + "������ ��: " + sum);

	}

}
