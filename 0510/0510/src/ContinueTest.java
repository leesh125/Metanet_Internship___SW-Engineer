
public class ContinueTest {

	public static void main(String[] args) {
		int sum = 0; // 1+2+4+5+... : 3�� ����� ������ 1 ~ 100 ������ ��
		
		for(int i=1; i<=100; i++) {
			if(i % 3 == 0) continue;
			sum += i;
		}
		System.out.println("3�� ����� ������ 1 ~ 100 ������ ��: " + sum);

	}

}
