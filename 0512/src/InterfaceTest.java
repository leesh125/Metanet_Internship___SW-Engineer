interface IClick {
	void iclick();
}

class Button {
	IClick ibclick;
	
	void regClick(IClick iclick) {
		ibclick = iclick;
	}
	
	void click() {
		System.out.println("버튼이 들어갔다 나옴");
		if(ibclick != null) {
			ibclick.iclick();
		}
	}
}

class LoginClick implements IClick {
	@Override
	public void iclick() {
		System.out.println("로그인 처리");
	}
}

public class InterfaceTest {

	public static void main(String[] args) {
		Button loginBtn = new Button();
		loginBtn.regClick(new LoginClick());
//		loginBtn.regClick(new Iclick() {
//		@Override
//		public void iclick() {
//			System.out.println("로그인 처리");
//		}
//		});
		loginBtn.click();

	}

}
