package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.models.Musical;

@WebService(endpointInterface="com.revature.services.MusicalService")
public class MusicalServiceImpl implements MusicalService {
	
	private List<Musical> musicals = new ArrayList<>();
	
	public MusicalServiceImpl() {
		super();
		musicals.add(new Musical("Cats", "T.S. Eliot", 140));
		musicals.add(new Musical("Wicked", "Winnie Holzman", 165));
		musicals.add(new Musical("The Book of Mormon", "Matt Stone, Robert Lopez, and Trey Parker", 155));
	}

	@Override
	public List<Musical> getAllMusicals() {
		return new ArrayList<>(musicals);
	}

	@Override
	public String addMusical(Musical musical) {
		musicals.add(musical);
		return musical.getTitle()+" added to the list";
	}

}
