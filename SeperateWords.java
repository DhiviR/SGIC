public class SeperateWords {

	public static void main(String[] args) {
		String fruit = "apple,banana,pineapple,avacoda,mango";
		String[] arr = fruit.split(",");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}