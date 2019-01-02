package Services;

import java.util.List;

import javax.ejb.Local;

import Entites.Appointment;
 
@Local
public interface RendezVousServiceLocal
{
	public List<Appointment> getRevParUser(int id);
	public String AnnulerRdv(int id);
	public List<Appointment> GetRdvs();
	public int CalculTotalrdv();
}
