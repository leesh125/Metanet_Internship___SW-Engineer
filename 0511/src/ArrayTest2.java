
public class ArrayTest2 {

	public static int add(int[] arr) {
		int sum = 0;
		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		int[] arr1 = {10,20,30,40,50};
		System.out.println(add(arr1));
		
		int[] arr2 = new int[] {100,200,300,400,500};
		System.out.println(add(arr2));
		
		// System.out.println(add({1,2,3,4,5})); // error
		System.out.println(add(new int[] {1,2,3,4,5}));
	}
		
}


