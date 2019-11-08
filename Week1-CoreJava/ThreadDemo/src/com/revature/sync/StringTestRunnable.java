package com.revature.sync;

public class StringTestRunnable implements Runnable {
	
	StringBuilder sbuilder = new StringBuilder();
	StringBuffer sbuffer = new StringBuffer();
	char c = '~';
	
	public StringTestRunnable() {
		super();
	}
	
	public StringTestRunnable(StringBuilder sbuilder, StringBuffer sbuffer) {
		super();
		this.sbuffer = sbuffer;
		this.sbuilder = sbuilder;
	}
	
	public StringTestRunnable(StringBuilder sbuilder, StringBuffer sbuffer, char c) {
		super();
		this.sbuffer = sbuffer;
		this.sbuilder = sbuilder;
		this.c = c;
	}

	@Override
	public void run() {
		for(int i=0; i<50; i++) {
			sbuilder = sbuilder.append(c);
			sbuffer = sbuffer.append(c);
		}
		
	}

}
