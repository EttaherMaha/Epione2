package Services;

import java.util.List;

import javax.ejb.Local;

import Entites.User;

@Local
public interface UserConnecteServiceLocal 
{
	public User lister(int id);
	public List<User> getListUsers();
	public User getUserConecte(String email);
}
