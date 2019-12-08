package dao;

import java.util.List;
import models.Employee; 

public interface EmployeeDao {
	public int createEmpl(Employee e); 
	public int updateEmpl(int emplId, String password, String email, String phone); 
	public List<Employee> getAllEmpl(); 
	public Employee getEmplById(int id); 
	public Employee emplLogin(String email, String password); 
}
