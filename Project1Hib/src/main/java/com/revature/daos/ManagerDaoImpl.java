package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.Manager;
import com.revature.util.HibernateUtil;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public List<Manager> getManagers() {
		
		List<Manager> managers = null;
		try (Session s = HibernateUtil.getSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Manager> cq = cb.createQuery(Manager.class);
			
			cq.select(cq.from(Manager.class));
			
			Query<Manager> query = s.createQuery(cq);
			managers = query.list();
		}
		return managers;
	}

	@Override
	public Manager getManagerByUsername(String username) {
		
		try(Session s = HibernateUtil.getSession()){
			String hql = "from Manager where user_name = :usernameVar";
			Query<Manager> q = s.createQuery(hql, Manager.class);
			q.setParameter("usernameVar", username);
			Manager m = q.getSingleResult();
			return m;
		}
	}
}
