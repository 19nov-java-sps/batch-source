package com.revature.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileDriver {

	public static void main(String[] args) {
		
		String path = "src/com/revature/io/write_data1.txt";
		
		try(FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr)){
			
			String line = br.readLine();
			
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Wrong path you bozo try again");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
