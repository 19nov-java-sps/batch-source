package com.revature.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String pathString = "src/com/revature/io/write_data.txt";
		
		try ( FileWriter fWriter = new FileWriter(pathString);
				BufferedWriter  bWriter = new BufferedWriter(fWriter)) {
				bWriter.append("Hello World, this is peter");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
