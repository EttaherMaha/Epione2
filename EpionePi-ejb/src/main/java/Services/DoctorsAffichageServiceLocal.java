package Services;

import java.util.List;

import javax.ejb.Local;

import Entites.User;

@Local
public interface DoctorsAffichageServiceLocal 
{
	
	public List<User> GetDoctors();
	public User lister(int id);
	public User getDoctor(int id);
}
