public class VariableTest {

	public static void main(String[] args) {
		char ch = 'A';
		String str = "A";
		int n = 100;
		long l = 100L;
		float f = 3.14F;
		double d = 3.14; 
		boolean b = true;
		int hex = 0x100;
		System.out.println(hex);
		
		String h = "h";
		for(int i=0; i<10;i++) {
			h = h+'h';
		} // h가 가리키는 주소의 값을 가져와서 'h'를 더한 후 h에 다시 덮어쓴다
		System.out.println(h);
		
		String name = "hong";
		int age = 20;
		double height = 198.3;
		String info = name + "," + age + ", " + height;
		System.out.println(info);
		String numStr1 = 8+8+"8"; // 168
		String numStr2 = "8"+8+8; // 888
		System.out.println(numStr1 + numStr2);
		
		int n1,n2,n3;
		n1=n2=n3=0; // 한번에 대입
		
		int i=0;
//		i++; // i=i+1
//		++i; // i=i+1
		
		int r;
		// r = ++i; // r=1, i=1
		// r = i++; // r=0, i=1
		System.out.println(++i);
		System.out.println(i);
		
		int x = 10;
		if (x >10 && (++i)>10) { // && 연산자는 앞에 조건이 거짓이면 뒤에 수행안함			
		}
		System.out.println(i);
		
		byte b1 = 10;
		byte b2 = 20;
		byte res = (byte)(b1+b2);
		
		int x1=12, y1 = 10;
		System.out.println(x1^y1);
		
		int m = 10;
		// m += 5; // m = m+5  m = 15
		m *= 3+5; // m = m*(3+5)
	}

}
