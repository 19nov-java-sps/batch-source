package com.revature.delegates;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.dao.ReimbursementDao;
import com.revature.daoimpl.ReimbursmentDaoImpl;
import com.revature.model.Reimbursement;

public class ReimbDeligate {

	private ReimbursementDao reimbDao = new ReimbursmentDaoImpl();
		
		public  void createReimbursement(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
			String rId=request.getParameter("rId");
			String descr=request.getParameter("descr");
			java.sql.Date date = null;//java.sql.Date(Calendar.getInstance().getTime().getTime());
			String status=request.getParameter("status");
			String sum=request.getParameter("sum");
			String emplId=request.getParameter("emplId");
			String fName=request.getParameter("fName");
			String lName=request.getParameter("lName");
			
			
			Reimbursement r =  new Reimbursement (Integer.parseInt(rId), descr,  date,   status, Double.parseDouble(sum), Integer.parseInt(emplId), fName, lName);
				
			
			reimbDao.createReimbursement(r);
		
		}
		
	}


