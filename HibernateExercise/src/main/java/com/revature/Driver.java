package com.revature;

import com.revature.daos.DepartmentDao;
import com.revature.daos.DepartmentDaoImpl;
import com.revature.daos.EmployeeDao;
import com.revature.daos.EmployeeDaoImpl;

public class Driver 
{
    public static void main( String[] args )
    {
        DepartmentDao deptDao = new DepartmentDaoImpl();
        EmployeeDao emplDao = new EmployeeDaoImpl();
        
        System.out.println(deptDao.getDepts().size());
        System.out.println(deptDao.getDeptById(2).getDeptName());
        
        System.out.println(emplDao.emplLogin("jia@gmail.com", "12345678").getFirstName());
    }
}
