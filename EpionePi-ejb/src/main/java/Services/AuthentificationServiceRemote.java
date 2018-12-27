package Services;

import javax.ejb.Remote;

import Entites.User;

@Remote
public interface AuthentificationServiceRemote 
{
	public String Login(User user);

}
