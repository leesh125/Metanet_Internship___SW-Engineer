
public class Rectangle extends Shape{
	private Point start = new Point();
	private int width;
	private int height;
	
	public Rectangle() {
		this("흰색",0,0,0,0);
	}

	public Rectangle(String color, int x, int y, int width, int height) {
		super(color);
		start = new Point(x,y);
		this.width = width;
		this.height = height;
	}

	public void drawRectangle() {
		System.out.println("[사각형 색 - " + getColor() + ", 시작점 - " + start.toString() + ", 가로 - " + width + ", 세로 -  " + height + "]"); 
	}

	@Override
	public void draw() {
		drawRectangle();
	}
}
