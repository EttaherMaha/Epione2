package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


import Entites.Appointment;
import Entites.User;

/**
 * Session Bean implementation class AuthentificationService
 */
@Stateless

public class AuthentificationService implements AuthentificationServiceRemote, AuthentificationServiceLocal {
	@PersistenceContext(unitName = "EpionePi-ejb")
	EntityManager em;

	@Override
	public String Login(User user) {
		// Create new JAX-RS client
		Client client = ClientBuilder.newClient();
		// URL of the service
		WebTarget target = client.target("http://localhost:10762/AccountWebServices/Login");
		// Get the response from the URL
		Response reponse = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
		// Read result as a string
		String result = reponse.readEntity(String.class);
		if (result.equals("")) {
			System.out.println("Erroooooooooooooooooooooooor");
			reponse.close();
			return result;
		} else {
			System.out.println(result);
			reponse.close();
			return result;
		}
	}

	@Override
	public List<Appointment> getApoint() {
		// Appointment app = new Appointment();
		// app = em.find(Appointment.class, 1);
		// System.out.println(app.getAppointementId());

		List<Appointment> us = new ArrayList<Appointment>();
		Query req = em.createQuery("SELECT u FROM Appointment u");
		try {
			us = req.getResultList();
		} catch (NoResultException e) {
			Logger.getAnonymousLogger();
		}
		return us;

	}

	@Override
	public List<User> getALLUsers() {
		List<User> us = new ArrayList<User>();

		Query req = em.createQuery("SELECT u FROM User u");
		try {
			us = req.getResultList();
		} catch (NoResultException e) {
			Logger.getAnonymousLogger();
		}
		return us;
	}

	@Override
	public void GetDoctors() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:10762/api/Users");

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		List<User> doctors = new ArrayList<User>();

		doctors = j.fromJson(result, new TypeToken<List<User>>() {
		}.getType());

		System.out.println(doctors.get(0).getFirstName());

		reponse.close();
		// return doctors;

	}

}
