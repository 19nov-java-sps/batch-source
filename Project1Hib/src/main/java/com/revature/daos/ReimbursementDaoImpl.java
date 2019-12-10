package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Reimbursement;
import com.revature.util.HibernateUtil;

public class ReimbursementDaoImpl implements ReimbursementDao  {

	@Override
	public List<Reimbursement> getReimbursements() {
		
		List<Reimbursement> reimbursements = null;
		try (Session s = HibernateUtil.getSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Reimbursement> cq = cb.createQuery(Reimbursement.class);
			
			cq.select(cq.from(Reimbursement.class));
			
			Query<Reimbursement> query = s.createQuery(cq);
			reimbursements = query.list();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getReimbursementsByUsername(String username) {
		
		try (Session s = HibernateUtil.getSession()) {
			
			String hql = "from Reimbursement where emp_user_name = :usernameVar";
			Query<Reimbursement> q = s.createQuery(hql, Reimbursement.class);
			q.setParameter("usernameVar", username);
			List<Reimbursement> reimbursementsByUsername = q.getResultList();
			return reimbursementsByUsername;
		}

	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(String status) {
		
		try (Session s = HibernateUtil.getSession()) {
			
			String hql = "from Reimbursement where status = :statusVar";
			Query<Reimbursement> q = s.createQuery(hql, Reimbursement.class);
			q.setParameter("statusVar", status);
			List<Reimbursement> reimbursementsByStatus = q.getResultList();
			return reimbursementsByStatus;
		}
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatusAndUsername(String status, String username) {
		
		try (Session s = HibernateUtil.getSession()) {
			
			String hql = "from Reimbursement where emp_user_name = :usernameVar and status = :statusVar";
			Query<Reimbursement> q = s.createQuery(hql, Reimbursement.class);
			q.setParameter("usernameVar", username);
			q.setParameter("statusVar", status);
			List<Reimbursement> reimbursementsByStatusAndUsername = q.getResultList();
			return reimbursementsByStatusAndUsername;
		}
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		
		try (Session s = HibernateUtil.getSession()) {
			
			String hql = "from Reimbursement where reim_id = :idVar";
			Query<Reimbursement> q = s.createQuery(hql, Reimbursement.class);
			q.setParameter("idVar", id);
			Reimbursement reimbursementById = q.getSingleResult();
			return reimbursementById;
		}
	}

	@Override
	public int updateReimbursement(int reim_id, String managerName, String status) {
		
		try(Session s = HibernateUtil.getSession()){
			
			Transaction tx = s.beginTransaction();
			Reimbursement r = this.getReimbursementById(reim_id);
//			Reimbursement r = new Reimbursement();
			r.setManagerName(managerName);
			r.setStatus(status);
			s.update(r);
			tx.commit();
			
			return 1;
		}

	}

	@Override
	public int createReimbursement(Reimbursement reimbursement) {
		
		int reimbursementCreated = 0;
		try(Session s = HibernateUtil.getSession()){
			
			Transaction tx = s.beginTransaction();
			reimbursementCreated = (int) s.save(reimbursement);
			tx.commit();
		}
		return reimbursementCreated;
	}

}
