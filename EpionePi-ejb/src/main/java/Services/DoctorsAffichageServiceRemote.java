package Services;

import java.util.List;

import javax.ejb.Remote;

import Entites.User;

@Remote
public interface DoctorsAffichageServiceRemote
{
	
	public List<User> GetDoctors();
	public User lister(int id);
	public User getDoctor(int id);

}
