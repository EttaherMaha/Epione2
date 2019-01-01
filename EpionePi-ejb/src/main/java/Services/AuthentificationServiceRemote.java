package Services;

import java.util.List;

import javax.ejb.Remote;

import Entites.Appointment;
import Entites.User;

@Remote
public interface AuthentificationServiceRemote
{
	public String Login(User user);
	public List<Appointment> getApoint() ;
	public List<User> getALLUsers() ;
	public String Register(User user) ;
}
