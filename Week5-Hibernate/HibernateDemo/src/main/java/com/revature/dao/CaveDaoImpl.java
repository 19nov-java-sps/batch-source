package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Cave;
import com.revature.util.HibernateUtil;

public class CaveDaoImpl implements CaveDao {
	
	private static Logger log = Logger.getRootLogger();

	/*
	 * Querying for data sets: 
	 * (1) use CriteriaQuery + CriteriaBuilder
	 * (2) use HQL (including saved queries)
	 * (3) use native SQL
	 * 
	 * + along with the Query interfaces
	 */
	@Override
	public List<Cave> getCaves() {
		Session s = HibernateUtil.getSession();
		
		CriteriaBuilder cb = s.getCriteriaBuilder();
		CriteriaQuery<Cave> cq = cb.createQuery(Cave.class);
		
		Root<Cave> root = cq.from(Cave.class);
		cq.select(root);
		
		Query<Cave> query = s.createQuery(cq);
		List<Cave> caves = query.list();
		
		s.close();
		return caves;
		
		/*
		Session s = HibernateUtil.getSession();
		Query<Cave> q  = s.createQuery("from Cave", Cave.class);
		List<Cave> caves = q.list();
		s.close();
		log.info("returning all caves");
		return caves;
		*/
	}

	/*
	 * Querying for one object by ID
	 * (1) could use any of our approaches above using the Query interface
	 * (2) get 
	 * 		- eager fetching strategy
	 * 		- returns null when an object with the requested id is not in db
	 * (3) load
	 * 		- lazy fetching strategy
	 * 		- returns a proxy, data isn't loaded into that proxy until it's requested
	 * 		- if the object is not in the db, load throws ObjectNotFoundException
	 * 		- if we try to access data outside of the session when the object
	 * 			was never actually filled w data, load throws a LazyInitializationException
	 * 
	 */
	@Override
	public Cave getCaveById(int id) {
		Cave c = null;
		try(Session s = HibernateUtil.getSession()){
			c = s.load(Cave.class, id);
			log.info("getting cave: "+c);
		}	
		return c;
	}

	
	/*
	 * 
	 * transient -> persistent state 
	 * 
	 * save:
	 * - returns serializable id - pk of persisted object
	 * - can make a transient or detached object persistent
	 * - can execute non transactionally if an insertion is the only way to get pk
	 *
	 * persist:
	 * - void return type, doesn't return pk
	 * - throw an exception if we attempt to make a detached object persistent
	 * - will not execute non-transactionally
	 * 
	 */
	@Override
	public int createCave(Cave cave) {
		int pk = 0;
		try (Session s = HibernateUtil.getSession();){
		Transaction tx = s.beginTransaction();
		pk = (int) s.save(cave);
		tx.commit();
		}
		return pk;
	}

	
	/*
	 * detached -> persistent state
	 * 
	 * update:
	 * - void return type
	 * - if there's already a persistent object in the session with the same ID
	 * 		update throws a NonUniqueObjectException
	 * - throws an exception if you try to update an object that doesn't exist 
	 *      in the db 
	 * 
	 * merge: 
	 * - if there is already a persistent object in the session with the same ID
	 *      the transient object will be merged with the persistent object
	 * - merged object is returned
	 * 
	 */
	@Override
	public void updateCave(Cave c) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(c);
			tx.commit();
		}
		
	}

	@Override
	public void deleteCave(int caveId) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.delete(new Cave(caveId));
			tx.commit();
		}
		
	}

}
