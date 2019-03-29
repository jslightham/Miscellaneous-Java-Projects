import processing.core.PApplet;

public class Main extends PApplet {
	public static int height = 1000;
	public static int width = 1000;
	public static int counter = 0;
	public static int numElements = 1000;
	public static int[] x = createArray(numElements);
	public static int slowDown = 1;
	public static int currentValue = 0;
	public static PlayTone sound = new PlayTone();

	public static void main(String[] args) {
		sound.test();
		PApplet.main("Main");
		SortingAlgorithms.mergeSort(x);

	}

	public void settings() {
		size(height, width);
	}

	public void setup() {
		frameRate(60);
	}

	public void draw() {
		// fill(150);
		// stroke(150);

		fill(244, 66, 66);
		noStroke();
		background(0);
		if (SortingAlgorithms.done == true) {
			fill(0, 224, 74);
			// stroke(0);
		}
		if(!mousePressed == true) {
			slowDown = 3;
		}else {
			slowDown =0;
		}
		for (int j = 0; j < x.length; j++) {
			fill(0, 150, (int)(0.2*x[j]));			
			rect(j * width / x.length, height - x[j], width / x.length, x[j]);
		}
	}
	
	//public void mouseClicked() {
		//	slowDown = 1;
	//}

	public static int[] createArray(int size) {
		int[] arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			//arr[i] = height - width / numElements * i;
			arr[i] = (int)(Math.random() * height);
		}
		for (int i = 0; i < 10; i++) {
			SortingAlgorithms.shuffle(arr);
		}
		return arr;
	}
}