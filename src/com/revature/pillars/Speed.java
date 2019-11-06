package com.revature.pillars;

import com.revature.exceptions.NegSpeedException;

public interface Speed {

	int speedUp();
	int speedDown() throws NegSpeedException;
}
