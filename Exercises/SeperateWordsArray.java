
public class SeperateWordsArray {

	public static void main(String[] args) {

		String fruit = "apple,banana,pineapple,avacoda";
		char[] arr = fruit.toCharArray();

		for (int i = 0; i < fruit.length(); i++) {
			if (fruit.charAt(i) != ',') {
				System.out.print(arr[i]);
			} else {
				System.out.println();
			}
		}
	}
}
