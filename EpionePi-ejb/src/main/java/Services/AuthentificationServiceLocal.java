package Services;

import javax.ejb.Local;

import Entites.User;

@Local
public interface AuthentificationServiceLocal
{
	public String Login(User user);

}
