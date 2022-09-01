package Exercise;

import java.util.Scanner;

public class RemoveWhiteSapces {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		String str = "";
//		
//		System.out.println("Write here");
//
//		while (scanner.hasNext()) {
//			str += scanner.next();
//		}
//		
//		System.out.println("I am running");
//		
//		System.out.println(str);
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		char[] ch = str.toCharArray();
		String output = "";
		
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] == ' ') {
				continue;
			} else {
				output += ch[i];
			}
		}
		
		System.out.println(output);
		
	}

}
