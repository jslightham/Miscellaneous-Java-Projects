import processing.core.PApplet;

public class Main extends PApplet{
		public int length = 2000;
		public int width = 5000;
		public static int[] x = createArray(1000);
		public static void main(String[] args) {
			PApplet.main("Main");
			insertionSort(x);
		}

		public void setup(){
		
		  frame.removeNotify();
		  frame.setUndecorated(true);
		  size(displayWidth, displayHeight);
		  textSize(64);
		  textAlign(CENTER,CENTER);
		}
		 
		public void draw(){
		  frame.setLocation(0,0);
		  background(0);
		  fill(0,255,0);
		  text("CLICK TO EXIT", width/2, height/2); 
		  
		  fill(0);
	      stroke(0);
	      background(255);
	      for(int j = 0; j<x.length; j++){
	          rect(j*width/x.length, height-x[j], width/x.length, x[j]);
	      }
	        
		}
		 
		public void mousePressed(){
		  exit();
		}
		public static int[] createArray(int size){
	        int[] arr = new int[size];

	        for (int i=0;i<arr.length; i++){
	            arr[i] = (int)(Math.random() * 1000);
	        }

	        return arr;
	    }
		
		public static void insertionSort(int[] arr) {

	        for(int i=1; i<arr.length; i++) {
	            int temp = arr[i];
	            int j;
	            for(j = i-1; j>=0 && temp < arr[j]; j--) {
	                arr[j+1] = arr[j];
	                try {
	                    Thread.currentThread().sleep(1);
	                }catch(Exception e){
	                    System.out.println(e);
	                }
	            }

	            arr[j+1] = temp;
	        }

	    }
		
		
}
