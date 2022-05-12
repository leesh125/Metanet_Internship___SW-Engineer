abstract class Base2 {
	abstract void func1();
	void func2() {
		func1();
	}
}

class Derived2 extends Base2 {
	@Override
	void func1() {
		System.out.println("func1");
	}
}
public class AbstractTest {

	public static void main(String[] args) {
		// Base2 b2 = new Base2(); // abstract class 생성 불가
		Derived2 d2 = new Derived2();
		d2.func2();
	}

}
