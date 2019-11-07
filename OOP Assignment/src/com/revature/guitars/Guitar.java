package com.revature.guitars;

import com.revature.abstraction.Instrument;

public class Guitar extends Instrument {
	
			private int width;
			private String guitarType;
	
	    public Guitar() {
		
		super();//call to super to get access to the numOfNotes variable
		setNumOfNotes(6);
	    }
		

//Constructor overloading  
		
		public Guitar(String guitarType, int width) {
			this();
			this.guitarType = guitarType;
			this.width = width;
		}
		
		public String getGuitarType() {
			return guitarType;
		}
		
		public void setGuitarType (String guitarType) {
			this.guitarType = guitarType;
			
		}
		//checked error (solution chosen from pop-up selection)
		public void myAbstractMethod() {
			// TODO Auto-generated method stub
			
		}

}
