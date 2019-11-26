import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedIO {

	public static void main(String[] args) throws Exception {

		try {
			FileOutputStream fout = new FileOutputStream("D:\\Test.txt");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			String s = "UPDATED: Ryan is practicing BufferedOutputSteam";
			byte b[] = s.getBytes();
			bout.write(b);
			bout.flush();
			bout.close();
			fout.close();
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
