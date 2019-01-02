package tn.esprit.Notifications;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entites.EtatNotification;
import Entites.NotificationRDV;
import Entites.TypeNotification;
import Entites.User;
import Services.NotificationServiceLocal;
import Services.RendezVousService;
import Services.UserConnecteServiceLocal;

@ManagedBean
@SessionScoped
public class notificationBean {
	private int idNotification;
	private Date dateNotification;
	private String description;
	private TypeNotification type;
	private EtatNotification etat;
	private User user;	
	private int idPatient;
	private int idDoctor;
	private List<NotificationRDV> notifications;
	private List<NotificationRDV> notificationsAll;
	private int nbrNotif;
	private int nbrRdv;



	@EJB
	NotificationServiceLocal notificationService;

	@EJB
	UserConnecteServiceLocal userService;
	
	@EJB
	RendezVousService rdvService;
	
	
	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
	}

	public Date getDateNotification() {
		return dateNotification;
	}

	public void setDateNotification(Date dateNotification) {
		this.dateNotification = dateNotification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeNotification getType() {
		return type;
	}

	public void setType(TypeNotification type) {
		this.type = type;
	}

	public EtatNotification getEtat() {
		return etat;
	}

	public void setEtat(EtatNotification etat) {
		this.etat = etat;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public List<NotificationRDV> getNotifications() {
		notifications = notificationService.GetNotificationByUserEtat(user.getId(), EtatNotification.NonLu);
		return notifications;
	}

	public void setNotifications(List<NotificationRDV> notifications) {
		this.notifications = notifications;
	}

	public List<NotificationRDV> getNotificationsAll() {
		for (NotificationRDV n : notificationService.GetNotificationByUserParEtat(user.getId(), EtatNotification.NonLu)) {
			notificationService.EditEtat(EtatNotification.Lu, n.getIdNotification());
		}
		return notificationService.GetNotificationByUser(2);
	}

	public void setNotificationsAll(List<NotificationRDV> notificationsAll) {
		this.notificationsAll = notificationsAll;
	}
	
	public int getNbrNotif() {
		int nbrNotif = notificationService.nbrNotifNonLu(EtatNotification.NonLu);
		return nbrNotif;
	}

	public void setNbrNotif(int nbrNotif) {
		this.nbrNotif = nbrNotif;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getNbrRdv() 
	{
		int nbrRdv = rdvService.GetRdvs().size();
		return nbrRdv;
	}

	public void setNbrRdv(int nbrRdv) {
		this.nbrRdv = nbrRdv;
	}
	
	
	
}
