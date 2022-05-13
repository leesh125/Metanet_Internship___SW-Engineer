
public class ExceptionTest2 {

	public static void func() throws Exception {
		String str = null;
		try {
			System.out.println(str.toString());			
		}catch (Exception e) {
			System.out.println("예외 1차처리");
			throw new Exception();
		}
	}
	
	public static void main(String[] args) {
		try {
			func();			
		} catch(Exception e) {
			System.out.println("예외 2차처리");
		}
	}

}
