package colourFinder;

import java.awt.image.*;
import java.io.*;


import javax.imageio.ImageIO;



public class Main {
	public static void main(String[] args) {
		//Change these for target colour
		int targetRed = 131;
		int targetGreen = 115;
		int targetBlue = 82;
		
		
		int previousBestScore = 765;
		int p;
		int r;
		int g;
		int b;
		int score;
		int bestX = 0;
		int bestY = 0;
		
		BufferedImage img = null;
		File file;
	    file = new File("test.jpg");
	    
	      try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

	    for(int i = 0; i <= img.getWidth() -1; i++) {
	    	
	    	for(int y = 0; y <= img.getHeight() -1; y++) {
	    		
	    		p = img.getRGB(i, y);
			    r = (p>>16) & 0xff;
			    g = (p>>8) & 0xff;
			    b = p & 0xff;
			    
			    //Score determines how close the current colour reading is to the goal
			    //Higher score - further away
			    score = Math.abs(Math.abs(targetRed - r) + Math.abs(targetGreen - g) + Math.abs(targetBlue - b));
			    if(previousBestScore > score) {
			    	previousBestScore = score;
			    	bestX = i;
			    	bestY = y;
			    	System.out.println(i + " " + y);
			    }
			  
	    	}
	    	
	    }
	    System.out.println("(" + bestX + ", " + bestY + ")");
	}
}
