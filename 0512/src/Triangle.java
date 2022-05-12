
public class Triangle extends Shape{
	private Point[] pos = new Point[3];
	
	public Triangle() {
		this("Èò»ö",new Point(),new Point(),new Point());
	}

	public Triangle(String color,int x1, int y1, int x2, int y2, int x3, int y3) {
		super(color);
		pos[0] = new Point(x1, y1);
		pos[1] = new Point(x2, y2);
		pos[2] = new Point(x3, y3);
	}

	public Triangle(String color,Point p1, Point p2, Point p3) {
		super(color);
		pos[0] = p1;
		pos[1] = p2;
		pos[2] = p3;
	}

	public void drawTriangle() {
		System.out.println("[»ï°¢Çü »ö - " + getColor() + ", Á¡1 - " + pos[0] + ", Á¡2 - " + pos[1] + ", Á¡3 - " + pos[2] + "]"); 
	}

	@Override
	public void draw() {
		drawTriangle();
	}
}
