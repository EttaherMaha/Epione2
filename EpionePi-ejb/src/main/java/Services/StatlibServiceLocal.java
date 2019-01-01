package Services;

import java.util.List;

import javax.ejb.Local;

import Entites.User;

@Local
public interface StatlibServiceLocal {

	List<User> getUserdocs();

}
