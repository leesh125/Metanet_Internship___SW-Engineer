class Test{
	final int n; // ����� �ʱ�ȭ �����ϳ� �����ڿ��� ���� �Ұ���. ��, ��� ��ü�� ���� ������ �ʱ�ȭ �ȴ�.
	
	static final int SN = 10; // static final ������ ����� �ʱ�ȭ�� �Ϲ���
	static {
		// sn = 20; // ����� �ʱ�ȭ�� �ȵǾ� ���� ��� ����.
	}
	
	// ���� ��õ��� ���� final ������ �����ڿ����� ���� ����
	Test(int n){
		this.n = n; // ����� �ʱ�ȭ�� �Ǿ����� ��� �����ڿ��� �ʱ�ȭ �Ұ���
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
