package wordCount;

public class Main {
	public static void main(String[] args) {
		String text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		String[] splittedString = new String[text.length()];
		int count = 0;
		splittedString = text.split("");
		if(splittedString[splittedString.length - 1].equals(" ")) {
			splittedString[splittedString.length - 1] = ".";
		}
		for(int i = 0; i <= text.length() - 1; i++) {
			if(splittedString[i].equals(" ")) {
				count ++;
			}
			if(splittedString[i].equals(" ") && splittedString[i + 1].equals(" ")) {
				count--;
			}
		}
		if(text.equals("")) {
			count = -1;
		}
		System.out.println(count + 1);
	}
}
