package Services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Entites.User;

@Stateless
@LocalBean
public class StatlibService implements StatlibServiceRemote, StatlibServiceLocal{

	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public StatlibService() {
        
    }
	
	
	//Stat
	public Long CountEtatCompteMActif() {
		TypedQuery<Long> query = em.createQuery("select count (*) from Speciality",
				Long.class);
		return (Long) query.getSingleResult();
		
	}
	
	public Long CountEtatCompteMSanctionne(){
		TypedQuery<Long> query = em.createQuery("select count (*) from Speciality",
				Long.class);
		return (Long) query.getSingleResult();
	}
	
	
	public Long CountEtatCompteM() {
		TypedQuery<Long> query = em.createQuery("select count (*) from Speciality",Long.class);
		return (Long) query.getSingleResult();
		
	}
	


	@Override
	public List<User> getUserdocs() {
		// TODO Auto-generated method stub
		return null;
	}
	public static String getws1() 
	{
		//Create new JAX-RS client 
		Client client = ClientBuilder.newClient();
		//URL of the service
		WebTarget target = client.target("http://localhost:10762/api/afficherdocto");
		//Get the response from the URL
		Response reponse = target.request().get();
		//Read result as a string
		ArrayList<LinkedHashMap> result1 = reponse.readEntity(ArrayList.class);
		String result=result1.get(1).get("doctolibNOM").toString() ;
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
