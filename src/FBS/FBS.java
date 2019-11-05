package FBS;

public class FBS {

	public static void main(String args[]) {
		int a = 0, b = 1, c = 0;
		for(int i = 0; i < 10; i++) {
			System.out.println(c = a + b);
			a = b;
			b = c;
		}
	}
}
