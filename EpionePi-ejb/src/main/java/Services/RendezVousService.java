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

import Entites.Appointment;


/**
 * Session Bean implementation class RendezVousService
 */
@Stateless
@LocalBean
public class RendezVousService implements RendezVousServiceRemote, RendezVousServiceLocal 
{
	@PersistenceContext(unitName = "EpionePi-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public RendezVousService() {
        // TODO Auto-generated constructor stub
    }


    @Override
	public List<Appointment> getRevParUser(int id)
	{
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:10762/AppointmentWS/GetAppointment?id=" + id);

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		List<Appointment> peop = new ArrayList<Appointment>();

		peop = j.fromJson(result, new TypeToken<List<Appointment>>() {
		}.getType());

		reponse.close();
		return peop;

	}


	@Override
	public String AnnulerRdv(int id) 
	{
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:10762/AppointmentWS/DeleteAppointment?id="+id);
		Response reponse = target.request(MediaType.APPLICATION_JSON).delete();
		String result = reponse.readEntity(String.class);
		System.out.println(result);
		reponse.close();
		return result;
	}
	
	
	@Override
	public List<Appointment> GetRdvs()
	{
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:10762/AppointmentWS/GetAppointments");

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		List<Appointment> rdvs = new ArrayList<Appointment>();

		rdvs = j.fromJson(result, new TypeToken<List<Appointment>>() {
		}.getType());

		System.out.println(rdvs.get(0).getAppointementId());

		reponse.close();
	    return rdvs;
	}


	@Override
	public int CalculTotalrdv() {
		Long lol = em
				.createQuery("select count(r) from Appointment r", Long.class)
				.getSingleResult();
		return lol.intValue();
	}

}
