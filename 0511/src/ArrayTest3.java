
public class ArrayTest3 {

	public static void main(String[] args) {
		int[] arr1 = new int[] {10,20,30};
		int[] arr2 = new int[3];
		//arr2 = arr1;
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		int[] arr3 = arr1.clone();
		arr1[0] = 100;
		System.out.println(arr2[0]);
		System.out.println(arr3[0]);
	}
}
