
public class Circle extends Shape{
	Point center;
	int radius;
	
	public Circle(String color, int x, int y, int radius) {
		super(color);
		center = new Point(x,y);
		this.radius = radius;
	}
	
	public Circle(String color, Point center, int radius) {
		super(color);
		this.center = center;
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void drawCircle() {
		System.out.println("[원 : 색 - " + getColor() + ", 중심점 - " + center + ", 반지름 - " + radius);
	}

	@Override
	public void draw() {
		drawCircle();
	}
	
	
}
