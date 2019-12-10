package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.models.Employee;
import com.revature.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		
		List<Employee> employees = null;
		try (Session s = HibernateUtil.getSession()) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
			
			cq.select(cq.from(Employee.class));
			
			Query<Employee> query = s.createQuery(cq);
			employees = query.list();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		
		try(Session s = HibernateUtil.getSession()){
			String hql = "from Employee where user_name = :usernameVar";
			Query<Employee> q = s.createQuery(hql, Employee.class);
			q.setParameter("usernameVar", username);
			Employee e = q.getSingleResult();
			return e;
		}
	}

	@Override
	public Employee getEmployeeById(int emp_id) {
		
		try(Session s = HibernateUtil.getSession()) {
			String hql = "from Employee where emp_id = :idVar";
			Query<Employee> q = s.createQuery(hql, Employee.class);
			q.setParameter("idVar", emp_id);
			Employee e = q.getSingleResult();
			return e;
		}
	}
	
	@Override
	public int updateEmployee(String fName, String lName, int emp_id) {
		
		try(Session s = HibernateUtil.getSession()){
			Transaction tx = s.beginTransaction();
			Employee e = this.getEmployeeById(emp_id);
//			Employee e = new Employee();
			e.setfName(fName);
			e.setlName(lName);
			s.update(e);
			tx.commit();
			
			return 1;
		}
	}

}
