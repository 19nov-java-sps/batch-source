package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {
		
		String path = "src/com/revature/io/write_data.txt";
		try (FileWriter fw = new FileWriter(path);BufferedWriter bw = new BufferedWriter (fw)){
			bw.append("HelloWorld");
			System.out.println("printing" + bw);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
