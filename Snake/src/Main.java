import processing.core.PApplet;

public class Main extends PApplet{
	public static int width = 800;
	public static int height = 800;
	public static int foodX;
	public static int foodY;
	public int yVel;
	public int xVel;
	public static int x;
	public static int y;
	public int score = 0;
	public static int[] tailX = new int[1];
	public static int[] tailY = new int[1];
	
	
	
	
	public static void main(String[] args) {
		PApplet.main("Main");
		generateFood();
	}
	
	public void settings() {
		size(width, height);
	}
	public void setup() {
		frameRate(15);
	}
	public void draw() {
		if (keyPressed) {
		    if (key == 's' || key == 'S') {
		      yVel = 25;
		      xVel = 0;
		    }
		  } if (key == 'w' || key == 'W') {
			  yVel = -25;
			  xVel = 0;
		  } if (key == 'a' || key == 'A') {
			  xVel = -25;
			  yVel = 0;
		  } if (key == 'd' || key == 'D') {
			  xVel = 25;
			  yVel = 0;
		  }
		  
		x+= xVel;
		y+= yVel;
		 tailX[0] = x;
		 tailY[0] = y;
		background(50);
		fill(255);
		stroke(255);
		for(int i = 0; i < tailX.length; i++) {
			rect(tailX[i], tailY[i], 25, 25);
		}
		fill(0, 0, 255);
		rect(foodX, foodY, 25, 25);
		
		if(x == foodX && y == foodY) {
			generateFood();
			score++;
			eat();
		}else {
			moveBack();
		}
		
		
		
	}
	
	public static void generateFood() {
		foodX = (int)(Math.random()*width/25)*25;
		foodY = (int)(Math.random()*height/25)*25;
		System.out.println(foodX);
	}
	
	public static void eat() {
		tailX = new int[tailX.length+1];
		tailY = new int[tailY.length+1];
		tailX[0] = x;
		tailY[0] = y;
		for(int i = 0; i < tailX.length - 1; i++) {
			tailX[i+1] = tailX[i];
			tailY[i+1] = tailY[i];
			
			System.out.println("Adding onto tail");
		}
		
	
	}
	
	public static void moveBack() {
		for(int i = 0; i < tailX.length - 1; i++) {
			tailX[i+1] = tailX[i];
			tailY[i+1] = tailY[i];
		}
	}
}
