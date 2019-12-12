package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.Department;
import com.revature.util.HibernateUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public List<Department> getDepts() {
		List<Department> depts = null;
		
		try(Session s = HibernateUtil.getSession()){
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<Department> cq = cb.createQuery(Department.class);
			
			cq.select(cq.from(Department.class));
			
			Query<Department> query = s.createQuery(cq);
			depts = query.list();
			log.info("getting all departments");
		}
		
		return depts;
	}

	@Override
	public Department getDeptById(int id) {
		try(Session s = HibernateUtil.getSession()){
			Department dept = s.get(Department.class, id);
			log.info("getting department" + dept);
			return dept;
		}
	}

}
