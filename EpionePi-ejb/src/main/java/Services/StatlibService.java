package Services;

import java.util.ArrayList;
import java.util.Iterator;
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
		TypedQuery<Long> query = em.createQuery("select count (*) from Suggestion",Long.class);
		return (Long) query.getSingleResult();
		
	}
	

   //end stat
	@Override
	public List<User> getUserdocs() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<User> getws1() 
	{
		//Create new JAX-RS client 
		Client client = ClientBuilder.newClient();
		//URL of the service
		WebTarget target = client.target("http://localhost:10762/api/afficherdocto");
		//Get the response from the URL
		Response reponse = target.request().get();
		//Read result as a string
		ArrayList<LinkedHashMap> result1 = reponse.readEntity(ArrayList.class);
		List<User> ListDLB = new ArrayList<User>()  ;
		
		for (LinkedHashMap item : result1) {
			User u=new User();
		u.setAddress(item.get("doctolibADD").toString());
		u.setFirstName(item.get("doctolibName").toString());
		u.setLastName(item.get("doctolibNOM").toString());
		u.setDegree(item.get("doctolibSPC").toString());
		   ListDLB.add(u);
		}
		String result=result1.get(1).get("doctolibNOM").toString() ;
		if (result.equals("")) 
		{
			System.out.println("Error");
			reponse.close();
			return ListDLB;
		} 
		else 
		{
			System.out.println(result);
			reponse.close();
			return ListDLB;
		}
	}
	public void getws2() 
	{
		//Create new JAX-RS client 
		Client client = ClientBuilder.newClient();
		//URL of the service
		WebTarget target = client.target("http://localhost:10762/api/sms");
		//Get the response from the URL
		Response reponse = target.request().get();
		//Read result as a string
	}

	
          }
