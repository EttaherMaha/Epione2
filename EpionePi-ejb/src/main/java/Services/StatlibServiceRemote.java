package Services;

import java.util.List;

import javax.ejb.Remote;

import Entites.User;

@Remote
public interface StatlibServiceRemote {
	List<User> getUserdocs();

}
