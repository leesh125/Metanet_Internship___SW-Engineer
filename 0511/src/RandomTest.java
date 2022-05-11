
public class RandomTest {
	public static void main(String[] args) {
		int[] ball = new int[45];
		for(int i=1; i<ball.length; i++) {
			ball[i] = i + 1;
		}
		
		for(int i=0; i<1000; i++) {
			// 0 X 45 <= Math.random()*45+1 < 1 X 45
			int rand1 = (int)(Math.random()*45);
			int rand2 = (int)(Math.random()*45);
			int temp = ball[rand1];
			ball[rand1] = ball[rand2];
			ball[rand2] = temp;
		}
		
		for(int i=0; i<6; i++) {
			System.out.println(ball[i] + " ");
		}
	}

}
