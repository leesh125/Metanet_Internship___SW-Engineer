import java.util.Scanner;

public class DoWhileTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0, input;
		
		do {
			input = sc.nextInt();
			sum += input;
		}while(input != 0);
		System.out.println(sum);
	}

}
