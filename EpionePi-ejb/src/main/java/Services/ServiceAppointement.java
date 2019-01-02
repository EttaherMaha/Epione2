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
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import Entites.AppointementJson;


/**
 * Session Bean implementation class Appointement
 */
@Stateless
@LocalBean
public class ServiceAppointement implements AppointementRemote, AppointementLocal {
	@PersistenceContext(unitName = "EpionePi-ejb")
	EntityManager em;

    /**
     * Default constructor. 
     */
    public ServiceAppointement() throws JsonParseException, 
    JsonMappingException{
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<AppointementJson> getAppointements() {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		//URL of the service
		WebTarget target = client.target("http://localhost:10762/AppointementApi/GetAppointmentsDoctor?id="+2);
		//Get the response from the URL
		Response reponse = target.request().get();
		//Read result as a string
		String result = reponse.readEntity(String.class);
		
		 ObjectMapper mapper = new ObjectMapper();
			
			mapper.configure(
				    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			List<AppointementJson> participantJsonList = new ArrayList<>();
	       try {
	        	//	mstCodes  = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Appointment.class));
	        	   //Appointment mstCode = mapper.readValue(result, Appointment.class);
	    	   participantJsonList = mapper.readValue(result, new TypeReference<List<AppointementJson>>(){});
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			//System.out.println(result);
return participantJsonList;
	}

	@Override
	public List<AppointementJson> getAppointementByMedicalRecord(int id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		//URL of the service
		WebTarget target = client.target("http://localhost:10762/AppointementApi/GetAppointmentsByMedicalRecord?id="+id);
		//Get the response from the URL
		Response reponse = target.request().get();
		//Read result as a string
		String result = reponse.readEntity(String.class);
		
		 ObjectMapper mapper = new ObjectMapper();
			
			mapper.configure(
				    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			List<AppointementJson> participantJsonList = new ArrayList<>();
	       try {
	        	//	mstCodes  = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Appointment.class));
	        	   //Appointment mstCode = mapper.readValue(result, Appointment.class);
	    	   participantJsonList = mapper.readValue(result, new TypeReference<List<AppointementJson>>(){});
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			//System.out.println(result);
return participantJsonList;
	}

	@Override
	public AppointementJson getAppointement(int id) {
		// TODO Auto-generated method stub
		Client client = ClientBuilder.newClient();
		//URL of the service
		WebTarget target = client.target("http://localhost:10762/AppointementApi/GetAppointment?id="+id);
		//Get the response from the URL
		Response reponse = target.request().get();
		//Read result as a string
		String result = reponse.readEntity(String.class);
		
		 ObjectMapper mapper = new ObjectMapper();
			
			mapper.configure(
				    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			 AppointementJson mstCode=new AppointementJson();
	       try {
	        	//	mstCodes  = mapper.readValue(result, mapper.getTypeFactory().constructCollectionType(List.class, Appointment.class));
	    	    mstCode = mapper.readValue(result, AppointementJson.class);
	    	 //  participantJsonList = mapper.readValue(result, new TypeReference<List<AppointementJson>>(){});
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			//System.out.println(result);
return mstCode;
	}

	@Override
	public void generatePdf() {
		// TODO Auto-generated method stub
		
	}

}
