package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public List<Employee> getEmpls() {
		List<Employee> empls = null;
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			
			cq.select(cq.from(Employee.class));
			
			Query<Employee> query = s.createQuery(cq);
			empls = query.list();
			log.info("getting all bears");
		}
		return empls;
	}

	@Override
	public Employee getEmplById(int id) {
		try(Session s = HibernateUtil.getSession()){
			Employee empl = s.get(Employee.class, id);
			log.info("getting employee" + empl);
			return empl;
		}
	}

	@Override
	public int createEmpl(Employee newEmpl) {
		int pk =0;
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			pk = (int) s.save(newEmpl);
			tx.commit();
		}
		return pk;
	}

	@Override
	public void updateEmpl(Employee empl) {
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			s.update(empl);
			tx.commit();
		}
	}

	@Override
	public Employee emplLogin(String email, String password) {
		try(Session s = HibernateUtil.getSession()){
			String hql = "from Employee where email = :email and pass = :password";
			Query<Employee> q = s.createQuery(hql, Employee.class);
			q.setParameter("email", email);
			q.setParameter("password", password);
			Employee empl = q.getSingleResult();
			return empl;
		}
	}

}
