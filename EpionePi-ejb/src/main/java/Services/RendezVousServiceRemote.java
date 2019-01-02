package Services;

import java.util.List;

import javax.ejb.Remote;

import Entites.Appointment;

@Remote
public interface RendezVousServiceRemote 
{
	public List<Appointment> getRevParUser(int id);
	public String AnnulerRdv(int id) ;
	public List<Appointment> GetRdvs();
	public int CalculTotalrdv();
}
