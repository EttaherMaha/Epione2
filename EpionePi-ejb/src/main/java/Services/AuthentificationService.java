package Services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Entites.User;

/**
 * Session Bean implementation class AuthentificationService
 */
@Stateless
@LocalBean
public class AuthentificationService implements AuthentificationServiceRemote, AuthentificationServiceLocal
{
	@PersistenceContext(unitName = "EpionePi-ejb")
	EntityManager em;


	@Override
	public String Login(User user) 
	{
		//Create new JAX-RS client 
		Client client = ClientBuilder.newClient();
		//URL of the service
		WebTarget target = client.target("http://localhost:10762/AccountWebServices/Login");
		//Get the response from the URL
		Response reponse = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
		//Read result as a string
		String result = reponse.readEntity(String.class);
		if (result.equals("")) 
		{
			System.out.println("Error");
			reponse.close();
			return result;
		} 
		else 
		{
			System.out.println(result);
			reponse.close();
			return result;
		}
	}
}
