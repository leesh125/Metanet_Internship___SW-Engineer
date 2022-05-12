public class ShapeSet {
	static final int SHAPE_COUNT = 10;
	static Shape[] shapes = new Shape[SHAPE_COUNT];
	static int shapeCnt;

	public static void drawShapes() {
		for(int i=0; i<shapeCnt; i++) {
			shapes[i].draw();
		}
	}
	
	public static void main(String[] args) {
		shapes[shapeCnt++] = new Circle("ÆÄ¶û",5,5,10); 
		shapes[shapeCnt++] = new Triangle("ÆÄ¶û",10,10,20,20,30,30);
		shapes[shapeCnt++] = new Triangle("ÆÄ¶û",10,10,20,20,30,30);
		shapes[shapeCnt++] = new Triangle("ÆÄ¶û",15,15,25,25,35,35);
		shapes[shapeCnt++] = new Rectangle("ÆÄ¶û",50,50,50,50);
		drawShapes();
	}

}
