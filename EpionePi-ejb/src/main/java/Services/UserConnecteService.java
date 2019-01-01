package Services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Entites.User;

/**
 * Session Bean implementation class UserConnecteService
 */
@Stateless
@LocalBean
public class UserConnecteService implements UserConnecteServiceRemote, UserConnecteServiceLocal 
{
	@PersistenceContext(unitName = "EpionePi-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public UserConnecteService() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public User lister(int id)
    {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:10762/AccountWebServices/GetUser?id=" + id);

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		User peop = new User();

		peop = j.fromJson(result, new TypeToken<User>() {
		}.getType());

		reponse.close();
		return peop;

	}

    @Override
	public List<User> getListUsers() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:10762/AccountWebServices/GetUsers");

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		List<User> peop = new ArrayList<User>();

		peop = j.fromJson(result, new TypeToken<List<User>>() {
		}.getType());

		reponse.close();
		return peop;

	}

	@Override
	public User getUserConecte(String email) 
	{
		List<User> users = getListUsers();
		User userConnecte = null;
		for (User user : users) {
			if (user.getEmail().equals(email)) {

				userConnecte = user;
				
			}
		}
		System.out.println(userConnecte.getId());
		return userConnecte;
	}

}
