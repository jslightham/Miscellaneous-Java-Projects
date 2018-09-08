package wordCount;

public class Main {
	public static void main(String[] args) {
		String text = "Hello there.";
		String[] splittedString = new String[text.length()];
		int count = 0;
		splittedString = text.split("");
		for(int i = 0; i <= text.length() - 1; i++) {
			if(splittedString[i].equals(" ")) {
				count ++;
			}
			if(splittedString[i].equals(" ") && splittedString[i + 1].equals(" ")) {
				count--;
			}
		}
		System.out.println(count);
	}
}
