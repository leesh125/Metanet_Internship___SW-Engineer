
public class ExceptionTest2 {

	public static void func() throws Exception {
		String str = null;
		try {
			System.out.println(str.toString());			
		}catch (Exception e) {
			System.out.println("���� 1��ó��");
			throw new Exception();
		}
	}
	
	public static void main(String[] args) {
		try {
			func();			
		} catch(Exception e) {
			System.out.println("���� 2��ó��");
		}
	}

}
