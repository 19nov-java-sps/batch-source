package com.revature.dao.impl;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {
	
	
	@Override
	public List<User> getUserTable(){
		 
		List<User> userTable = null;
		
		try (Session s = HibernateUtil.getSession()){
				CriteriaBuilder cb = s.getCriteriaBuilder();
				CriteriaQuery<User> cq = cb.createQuery(User.class);
				
				cq.select(cq.from(User.class));
				
				Query<User> query = s.createQuery(cq);
				userTable = query.list();
		}
		return userTable;
		
	}
			
				
	
	@Override
	public User getUserById(int userId) {
		
		try(Session s = HibernateUtil.getSession()) {
			
			String hql = "from User where user_id = :idVar";
			Query<User> q = s.createQuery(hql, User.class);
			q.setParameter("idVar", userId);
			User u = q.getSingleResult();
			return u;
		}
	}

	
	
	@Override
	public int updateUser(String firstName, String lastName, int userId) {
		
		try(Session s = HibernateUtil.getSession()){
			
			Transaction tx = s.beginTransaction();
			User u = this.getUserById(userId);
			u.setFirstName(firstName);
			u.setLastName(lastName);
			u.setUserId(userId);
			s.update(u);
			tx.commit();
			
			
			return 1;
		}
	}
		
	

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		
		
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from User where user_name = :usernameVar and pass_word = :passwordVar";
			Query<User> q = s.createQuery(hql, User.class);
			q.setParameter("usernameVar", username);
			q.setParameter("passwordVar", password);
			
			User u = null;
			List<User> users = q.list();
			if(users.size()>0) {
				u = q.list().get(0);
			}
			return u;
		}
	}
}
		


