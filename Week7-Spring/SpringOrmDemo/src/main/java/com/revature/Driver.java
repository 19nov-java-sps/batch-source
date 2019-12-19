package com.revature;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.daos.TrackDao;
import com.revature.daos.TrackDaoImpl;
import com.revature.models.Track;

public class Driver {

	public static void main(String[] args) {

//		TrackDao trackDao = new TrackDaoImpl();
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		TrackDao trackDao = (TrackDao) ac.getBean("trackDaoImpl");
		
		
		List<Track> tracks = trackDao.getAll();
		for(Track t: tracks) {
			System.out.println(t);
		}

	}

}
