package Exercise;

import java.util.Scanner;

public class RemoveWhiteSpacesUsingInBuilt {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String str = scanner.nextLine();
		
		String s = str.replaceAll(" ", "");
		
		System.out.println(s);

	}

}
