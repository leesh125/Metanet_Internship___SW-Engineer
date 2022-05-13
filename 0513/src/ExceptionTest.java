public class ExceptionTest {
	public static void main(String[] args) {
		String str = null;
		int[] arr1 = {10,20,40,50};
		int[] arr2 = {2,0,4};
		
		
		for(int i=0; i<arr1.length;i++) {
			try {
				System.out.println(arr1[i]/arr2[i]);								
			}catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스가 초과되었습니다.");
			}
		}
		
		System.out.println("exit");
	}

}
