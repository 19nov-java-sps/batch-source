package dao;

import java.util.List;
import models.Reimbursement;

public interface ReimbursementDao {
	public int createReim(double amount, int emplId, String description); 
	public int updateReim(int reimId, int managerId, String result, String reason); 
	public Reimbursement getReimById(int reimId); 
	public List<Reimbursement> getPendingReim(); 
	public List<Reimbursement> getResolvedReim(); 
	public List<Reimbursement> getPendingReimById(int emplId); 
	public List<Reimbursement> getResolvedReimById(int emplId); 
}
