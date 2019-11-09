package com.revature.sync;

public class StringTestRunnable implements Runnable {
	
	StringBuilder sbuilder = new StringBuilder();// Creates a new object of type Stringbuilder
	StringBuffer sbuffer = new StringBuffer();//Creates a new object of type StringBuffer(Serializable)
	char c = '~';
	
	public StringTestRunnable() {// constructor for StringTestRunnable Object
		super();
	}
	
	public StringTestRunnable(StringBuilder sbuilder, StringBuffer sbuffer) {//Parameterized constructor for StringTestRunnable
		super();
		this.sbuffer = sbuffer;
		this.sbuilder = sbuilder;
	}
	
	public StringTestRunnable(StringBuilder sbuilder, StringBuffer sbuffer, char c) {//Parameterized constructor for StringTestRunnable
		super();
		this.sbuffer = sbuffer;
		this.sbuilder = sbuilder;
		this.c = c;
	}

	@Override
	public void run() {
		for(int i=0; i<50; i++) {
			sbuilder = sbuilder.append(c);//run method which should append c to the aforementioned created string items 50 time for each
			sbuffer = sbuffer.append(c);
		}
		
	}

}
