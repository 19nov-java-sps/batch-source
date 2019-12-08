package com.revature.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Bear;
import com.revature.util.HibernateUtil;

public class BearDaoImpl implements BearDao {
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public List<Bear> getBears() {
		List<Bear> bears = null;
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Bear> cq = cb.createQuery(Bear.class);
			
			cq.select(cq.from(Bear.class));
			
			Query<Bear> query = s.createQuery(cq);
			bears = query.list();
			log.info("getting all bears");
		}
		return bears;
	}

	@Override
	public Bear getBearById(int id) {
		try(Session s = HibernateUtil.getSession()){
			Bear b = s.get(Bear.class, id);
			log.info("getting bear"+b);
			return b;
		}
	}

	@Override
	public int createBear(Bear b) {
		int pk =0;
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			pk = (int) s.save(b);
			tx.commit();
		}
		return pk;
	}

	@Override
	public void updateBear(Bear b) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(b);
			tx.commit();
		}
		
	}

	@Override
	public void deleteBearById(int bearId) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.delete(new Bear(bearId));
			tx.commit();
		}
		
	}

	@Override
	public List<Bear> getBearsByName(String name) {
		/*// using native sql
		try(Session s = HibernateUtil.getSession()){
			String sql = "select * from bear where bear_name = ?";
			Query<Bear> q = s.createNativeQuery(sql, Bear.class);
			q.setParameter(1, name);
			List<Bear> bears = q.list();
			return bears;
		}
		*/

		/* // using HQL (Hibernate Query Language) 
		try(Session s = HibernateUtil.getSession()){
			String hql = "from Bear where name = :nameVar";
			Query<Bear> q = s.createQuery(hql, Bear.class);
			q.setParameter("nameVar", name);
			List<Bear> bears = q.list();
			return bears;
		}
		*/
		
		/* // using a named query
		try(Session s = HibernateUtil.getSession()){
			Query<Bear> q = s.getNamedQuery("getByName");
			q.setParameter("nameVar", name);
			List<Bear> bears = q.list();
			return bears;
		}
		*/
		
		// using a CriteriaQuery
		
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Bear> cq = cb.createQuery(Bear.class);
			
			Root<Bear> root = cq.from(Bear.class); // define root
			cq.select(root); // specify columns 
			
			cq.where(cb.equal(root.get("name"), name)); // specify where clause
			
			Query<Bear> query = s.createQuery(cq);
			List<Bear> bears = query.list();
			return bears;
		}
		
	}

	@Override
	public List<Bear> getYBears() {
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Bear> cq = cb.createQuery(Bear.class);
			
			Root<Bear> root = cq.from(Bear.class);
			cq.select(root); // cq.select(root.get("name")) allows you to select a specific column
//			cq.where(cb.and(cb.like(root.get("name"), "Y%"),cb.greaterThan(root.get("id"), 4)));
			
			cq.where(cb.like(root.get("name"), "Y%"));
			
			Query<Bear> q = s.createQuery(cq);
			return q.list();
		}
	}

	@Override
	public long getBearCount() {
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Long> cq = cb.createQuery(Long.class);
			
			Root<Bear> root = cq.from(Bear.class);
			cq.select(cb.count(root));
			
			Query<Long> query = s.createQuery(cq);
			Long count = query.getSingleResult();
			return count;
		}
	}
	
	

}
