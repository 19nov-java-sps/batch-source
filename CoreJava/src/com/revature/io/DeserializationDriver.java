package com.revature.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "src/com/revature/io/serialized.ser";
		
	
		try(FileInputStream fis = new FileInputStream(path);
				ObjectInputStream ois = new ObjectInputStream(fis)){
			
			Pen p = (Pen) ois.readObject(); 
			
			System.out.println(p);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
