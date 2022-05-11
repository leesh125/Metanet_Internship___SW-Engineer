public class RandomTest2 {
	public static void main(String[] args) {
		boolean[] ball = new boolean[46];
		int index = 0, rand1 = 0;
		
		while(index < 6) {
			rand1 = (int)(Math.random()*45+1); // 1 ~ 45
			if(!ball[rand1]) {
				System.out.print(rand1 + " ");
				ball[rand1] = true;
				index += 1;
			}
		}
	}

}
