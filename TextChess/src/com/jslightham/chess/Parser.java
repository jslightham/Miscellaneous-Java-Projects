package com.jslightham.chess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Parser {
	public Parser() {
		
	}
	public static Command getCommand(){
		String inputLine = "";
		String fromRow = "", fromCol = "", toRow = "", toCol ="";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			inputLine = reader.readLine();
		} catch (java.io.IOException exc) {
			System.out.println("There was an error during reading: " + exc.getMessage());
		}
		
		return new Command(fromCol, fromRow, toCol, toRow);
	}
}
