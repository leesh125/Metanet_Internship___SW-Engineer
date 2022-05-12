interface Attackable{
	void attack();
}

class Fighter1 implements Attackable{
	@Override
	public void attack() {
		System.out.println("앞차기 공격");
	}
}

class Fighter2 implements Attackable{
	@Override
	public void attack() {
		System.out.println("돌려차기 공격");
	}
}

public class InterfaceTest2 {
	static Attackable[] fighters = new Attackable[10];
	static int cnt;
	static void addFighter(Attackable f) {
		fighters[cnt++] = f;
	}
	
	public static void main(String[] args) {
		addFighter(new Fighter1());
		addFighter(new Fighter2());
	}

}
