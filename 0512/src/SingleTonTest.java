class OneArray {
	int[] array = new int[100];
	private OneArray() {}
	static OneArray oneArray;
	static OneArray getArrayRef() {
		if(oneArray == null) {
			oneArray = new OneArray();
		}
		return oneArray;
	}
	
	void setData(int idx, int data) {
		array[idx] = data;
	}
	
	int getData(int idx) {
		return array[idx];
	}
}
public class SingleTonTest {

	public static void main(String[] args) {
		// OneArray oa = new OneArray(); // private 积己磊 积己 阂啊.
		OneArray oa1 = OneArray.getArrayRef();
		OneArray oa2 = OneArray.getArrayRef();
		oa1.setData(0, 100);
		System.out.println(oa2.getData(0));
	}

}
