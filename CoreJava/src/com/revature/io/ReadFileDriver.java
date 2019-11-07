package com.revature.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathString = "src/com/revature/io/write_data.txt";
		 try (FileReader fReader = new FileReader(pathString);
			 BufferedReader  bReader = new BufferedReader(fReader)) {
			 
			 String lineString = bReader.readLine();
			 
			 while (lineString != null) {
				 System.out.println(lineString);
				 lineString = bReader.readLine();
			 }
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
