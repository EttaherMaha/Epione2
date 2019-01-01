package tn.esprit.rendez_vous;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entites.Appointment;
import Entites.User;
import Services.DoctorsAffichageServiceLocal;
import Services.RendezVousServiceLocal;

@ManagedBean
@SessionScoped
public class rendezVousBean {
	private int appointementId;
	private String dateAppointement;
	private int doctorId;
	private String message;
	private User user;
	private String reason;
	private String state;
	private List<Appointment> rdvs;
	private User doctor;

	@EJB
	RendezVousServiceLocal rdvService;

	@EJB
	DoctorsAffichageServiceLocal serviceLocalDoctor;
	
	public String AnnulerRdv(String id) 
	{		System.out.println(id);

		String navigateTo = "";	
		int idA = Integer.parseInt(id);
		System.out.println(idA);
		rdvService.AnnulerRdv(idA);
		navigateTo = "index.jsf";
		return navigateTo;
	}
	
	public List<Appointment> getRdvs() {
		rdvs = rdvService.getRevParUser(user.getId());
		for (Appointment appointment : rdvs) {
			System.out.println(appointment.getAppointementId());
			appointment.setDoctor(serviceLocalDoctor.getDoctor(appointment.getDoctorId()));
		}
		return rdvs;
	}

	public void setRdvs(List<Appointment> rdvs) {
		this.rdvs = rdvs;
	}

	public int getAppointementId() {
		return appointementId;
	}

	public void setAppointementId(int appointementId) {
		this.appointementId = appointementId;
	}

	public String getDateAppointement() {
		return dateAppointement;
	}

	public void setDateAppointement(String dateAppointement) {
		this.dateAppointement = dateAppointement;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getDoctor() {

		// doctor = serviceLocalDoctor.getDoctor(doctorId);
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

}
