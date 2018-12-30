package Services;

import java.util.List;

import javax.ejb.Remote;

import Entites.User;

@Remote
public interface UserConnecteServiceRemote
{
	public User lister(int id);
	public List<User> getListUsers();
	public User getUserConecte(String email);
}
