import processing.core.PApplet;

public class Main extends PApplet{
	public int width = 800;
	public int height = 800;
	public int paddleOneX = 0;
	public int paddleOneY = 0;
	
	public int paddleTwoX = width - 25;
	public int paddleTwoY = 0;
	
	public int ballX = 400;
	public int ballY = 400;
	
	public int ballXVel = 3;
	public int ballYVel = 3;
	
	public int p1Score = 0;
	public int p2Score = 0; 
	public int paddleTwoDirection;
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
		paddleOneY = ballY - 10;
		if(paddleTwoY > ballY - 10) {
			paddleTwoDirection = -1;
		}else {
			paddleTwoDirection = 1;
		}
		paddleTwoY += paddleTwoDirection;
				
		background(0);
		fill(255);
		stroke(255);
		rect(paddleOneX, paddleOneY, 25, 100);
		rect(paddleTwoX, paddleTwoY, 25, 100);
		rect(ballX, ballY, 25, 25);
		
		ballX+= ballXVel;
		ballY+= ballYVel;
		
		if(ballY > height - 25) {
			ballYVel = -(int)(Math.random() *10);
		}
		
		if(ballY < 0) {
			ballYVel = (int)(Math.random() *10);
		}
		
		if(ballX >= width - 50 && (ballY < paddleTwoY + 100 && ballY > paddleTwoY)) {
			ballXVel = -3;
			ballYVel = (int)(Math.random() *10);
			
		}
		if(ballX <= 25 && (ballY < paddleOneY + 100 && ballY > paddleOneY)) {
			ballXVel = 3;
			ballYVel = (int)(Math.random() *10);
			
		}
		if((ballX < 15) && !(ballY < paddleOneY + 100 && ballY > paddleOneY)) {
			ballXVel = 3;
			ballYVel = (int)(Math.random() *10);
			
			p1Score++;
		}
		if((ballX > 785) && !(ballY < paddleTwoY + 100 && ballY > paddleTwoY)) {
			ballXVel = -3;
			ballYVel = -(int)(Math.random() *10);
			p2Score++;
			
		}
		
		textSize(32);
		text(p1Score, 750, 30);
		text(p2Score, 50, 30);
		
	}
}
