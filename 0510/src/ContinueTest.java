
public class ContinueTest {

	public static void main(String[] args) {
		int sum = 0; // 1+2+4+5+... : 3의 배수를 제외한 1 ~ 100 까지의 합
		
		for(int i=1; i<=100; i++) {
			if(i % 3 == 0) continue;
			sum += i;
		}
		System.out.println("3의 배수를 제외한 1 ~ 100 까지의 합: " + sum);

	}

}
