
public class ArrayTest {

	public static void func1() {
		int n1;
		func2();
		System.out.println("func1()");
	}
	
	public static void func2() {
		int n2;
		func3();
		System.out.println("func2()");
	}
	
	public static void func3() {
		int n3;
		System.out.println("func3()");
	}
	public static void main(String[] args) {
		int n;
		func1();
		System.out.println("main");
		
		/* 출력 순서(스택) */
//		func3()
//		func2()
//		func1()
//		main

		// int[] narr = new int[5];

	}

}
