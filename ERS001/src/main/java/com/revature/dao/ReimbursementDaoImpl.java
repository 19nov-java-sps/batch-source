package com.revature.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.daos.ReimbursementDao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;
import com.revature.util.HibernateUtil;
import com.revature.model.Employees;
import com.revature.model.Reimbursements;
public class ReimbursementDaoImpl implements ReimbursementDao{

	@Override
	public List<Reimbursements> getResolvedReimbursements() {
		try(Session s= HibernateUtil.getSession()){
			Query q=s.createQuery("from Reimbursements where ispending=false");
			List<Reimbursements> reimbursements =q.list();
			return reimbursements;
		}
		
	}

	@Override
	public List<Reimbursements> getPendingReimbursements() {
		String hql = "select id, status from Reimbursements where ispending=true";
	
		
		try(Session s= HibernateUtil.getSession()){
			Query q=s.createQuery(hql);
			List<Reimbursements> reimbursements =q.list();
			return reimbursements;
		}
		
	}



	@Override
	public boolean createReimbursement(Reimbursements re) throws SQLException {
	double amount=re.getReimbursementAmount();
	String reason= re.getReasonForReimbursement();
	boolean isPending= re.isPending();
	int employeeid= re.getUserId();
	String status=re.getStatus();
	
		try(Session s= HibernateUtil.getSession()){
			Query q=s.createQuery("insert into Reimbursements(amount,employeeid,reasonfor,ispending,status) values(amount,employeeid,reason,isPending,status)");
			
			return true;
		}
		
	}

/*

	@Override
	public void resolveReimbursement(int i, int manager, String status) throws SQLException {
String sql2 = "update reimbursements set ispending=false, resolvedby=?, status=? where id=?";
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql2)) {
		
			ps.setInt(1,manager);

			ps.setString(2,status);
			
			ps.setInt(3,i );
			ps.executeUpdate();
	
	}
	}



	@Override
	public void resolveReimbursement(int i) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean createReimbursement(com.revature.dao.Reimbursement re) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean createReimbursement(com.revature.dao.Reimbursement re) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}

	*/
	
}