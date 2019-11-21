package com.revature;

import com.revature.scanner.MainMenu; 

public class Driver {

	public static void main(String[] args) {
		
		// Creates a new main menu that calls the 
		// mainMenuMsg method and allows the client to 
		// perform other account methods based on the
		// the options they choose
		MainMenu m = new MainMenu();
		m.mainMenuMsg();
			
			
	}

}
