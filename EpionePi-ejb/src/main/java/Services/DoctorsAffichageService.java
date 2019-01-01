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
 * Session Bean implementation class DoctorsAffichageService
 */
@Stateless
@LocalBean
public class DoctorsAffichageService implements DoctorsAffichageServiceRemote, DoctorsAffichageServiceLocal 
{
	@PersistenceContext(unitName = "EpionePi-ejb")
	EntityManager em;

	public User lister(int id) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:10762/AccountWebServices/GetDoctor?id=3");

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
	public List<User> GetDoctors() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:10762/AccountWebServices/GetDoctors");

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		List<User> doctors = new ArrayList<User>();

		doctors = j.fromJson(result, new TypeToken<List<User>>() {
		}.getType());

		System.out.println(doctors.get(0).getFirstName());

		reponse.close();
	    return doctors;
	}

	
	
	
	@Override
	public User getDoctor(int id) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:10762/AccountWebServices/GetDoctor?id=" + id);

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		User doctor = new User();

		doctor = j.fromJson(result, new TypeToken<User>() {
		}.getType());

		reponse.close();
		System.out.println(doctor.getId()   + doctor.getFirstName());
		return doctor;

	}

}
