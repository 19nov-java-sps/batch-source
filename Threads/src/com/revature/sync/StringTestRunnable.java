package com.revature.sync;

public class StringTestRunnable implements Runnable{

	StringBuilder sb = new StringBuilder();
	StringBuffer sbuffer = new StringBuffer();
	
	public StringTestRunnable() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	public StringTestRunnable(StringBuilder sb, StringBuffer sbuffer) {
		super();
		this.sb = sb;
		this.sbuffer = sbuffer;
	}


	@Override
	public void run() {
		for (int i = 0 ; i < 50; i++) {
			sb = sb.append('a');
			sbuffer = sbuffer.append('p');
		}
		
	}
	
}
