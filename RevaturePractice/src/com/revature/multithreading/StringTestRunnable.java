package com.revature.multithreading;

public class StringTestRunnable implements Runnable {

	StringBuilder sbuilder = new StringBuilder();
	StringBuffer sbuffer = new StringBuffer();

	public StringTestRunnable(StringBuilder sbuilder, StringBuffer sbuffer) {
		super();
		this.sbuilder = sbuilder;
		this.sbuffer = sbuffer;
	}

	@Override
	public void run() {

		for (int i = 0; i < 50; i++) {
			sbuilder = sbuilder.append("$");
			sbuffer = sbuffer.append("$");
		}
	}

}
