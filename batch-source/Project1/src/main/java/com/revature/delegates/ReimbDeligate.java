package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDao;
import com.revature.model.Reimbursement;

public class ReimbDeligate {

		public static void getAllReimbursement(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
			System.out.println ("I am in getAllEmpl method!!!!!!!");
			List<Reimbursement> reimbursssements = ReimbursementDao.getAllReimbursement();
			ObjectMapper om = new ObjectMapper();
			String employeesJSON = om.writeValueAsString(reimbursssements);
			System.out.println ("All employees " + reimbursssements);
			try(PrintWriter pw = response.getWriter();){
				pw.write(employeesJSON);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}


