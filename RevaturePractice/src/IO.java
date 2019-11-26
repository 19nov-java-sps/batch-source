import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class IO {

	public static void main(String[] args) {

		try {
			FileOutputStream fout = new FileOutputStream("d:\\Test.txt");
			String s = "Hello from JavaPoint";
			byte[] b = s.getBytes();
			fout.write(b);
			fout.close();
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
