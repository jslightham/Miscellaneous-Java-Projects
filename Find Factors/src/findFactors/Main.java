package findFactors;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Enter Number");
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		System.out.println(n);
		for(int i = 1; i < n; i++) {
			if(n % i == 0) {
				System.out.println(i);
			}
		}

	}

}
