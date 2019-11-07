package com.revature.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationDriver {

	public static void main(String[] args) {
		
		
		String pathString = "src/com/revature/io/serialized.ser";
		
		Pen p = new Pen(5, "blue", true, 3);
		
		try (FileOutputStream fosFileOutputStream = new FileOutputStream(pathString);
				ObjectOutputStream ooStream = new ObjectOutputStream(fosFileOutputStream)){
			ooStream.writeObject(fosFileOutputStream);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
