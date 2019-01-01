package Services;

import java.util.List;

import javax.ejb.Local;

import Entites.Appointment;
import Entites.User;

@Local
public interface AuthentificationServiceLocal
{
	public String Login(User user);
	public List<Appointment> getApoint();
	public List<User> getALLUsers() ;
	public String Register(User user) ;


}
