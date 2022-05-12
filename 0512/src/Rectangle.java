
public class Rectangle extends Shape{
	private Point start = new Point();
	private int width;
	private int height;
	
	public Rectangle() {
		this("���",0,0,0,0);
	}

	public Rectangle(String color, int x, int y, int width, int height) {
		super(color);
		start = new Point(x,y);
		this.width = width;
		this.height = height;
	}

	public void drawRectangle() {
		System.out.println("[�簢�� �� - " + getColor() + ", ������ - " + start.toString() + ", ���� - " + width + ", ���� -  " + height + "]"); 
	}

	@Override
	public void draw() {
		drawRectangle();
	}
}
