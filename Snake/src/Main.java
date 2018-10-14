import processing.core.PApplet;

public class Main extends PApplet{
	public int width = 800;
	public int height = 800;
	
	public static void main(String[] args) {

		PApplet.main("Main");
	}
	
	public void settings() {
		size(width, height);
	}
	public void setup() {
		frameRate(120);
	}
	public void draw() {
		background(50);
		fill(255);
		stroke(255);
		
		
	}
}
