class Test{
	final int n; // 명시적 초기화 가능하나 생성자에서 변경 불가능. 즉, 모든 객체가 같은 값으로 초기화 된다.
	
	static final int SN = 10; // static final 변수는 명시적 초기화가 일반적
	static {
		// sn = 20; // 명시적 초기화가 안되어 있을 경우 가능.
	}
	
	// 값이 명시되지 않은 final 변수는 생성자에서만 대입 가능
	Test(int n){
		this.n = n; // 명시적 초기화가 되어있을 경우 생성자에서 초기화 불가능
	}
	
	void func(int n) {
		// this.n = n;
	}
}
public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
