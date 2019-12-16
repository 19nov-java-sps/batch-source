package com.revature.daos;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Track;

@Repository
public class TrackDaoImpl implements TrackDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
//	@Transactional(propagation=Propagation.MANDATORY)
	public List<Track> getAll() {
		Session s = sf.getCurrentSession();
		List<Track> tracks = s.createQuery("from Track").list();
		return tracks;
	}

	@Override
	@Transactional
	public Track getById(int id) {
		Session s = sf.getCurrentSession();
		Track track = (Track) s.get(Track.class, id);
		return track;
	}

}
