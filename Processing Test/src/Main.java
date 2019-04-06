import processing.core.PApplet;

public class Main extends PApplet {
	private int width = 500;
	private int height = 500;
	private int x = 0;

	public static void main(String[] args) {
		PApplet.main("Main");
	}

	public void settings() {
		size(width, height);
	}

	public void setup() {
		frameRate(60);
	}
	
	public void draw() {
		background(0);
		fill(255);
		stroke(255);
		x++;
		rect(mouseX, mouseY, 50, 50);
	}
}
