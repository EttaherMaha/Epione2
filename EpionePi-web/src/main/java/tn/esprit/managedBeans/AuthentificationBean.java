package tn.esprit.managedBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entites.Role;
import Entites.User;
import Services.AuthentificationServiceLocal;
import Services.RendezVousServiceLocal;
import Services.UserConnecteServiceLocal;
import tn.esprit.Notifications.notificationBean;
import tn.esprit.rendez_vous.rendezVousBean;

@ManagedBean
@SessionScoped
public class AuthentificationBean {
	private String login;
	private String password;
	private User user;
	private User userConn;
	private boolean loggedIn = false;
	private String FirstName;
	private String LastName;
	private String address;
	private String phoneNumber;
	private Role pdf;
	private int nbrPatient;
	private int nbrDoctor;

	@ManagedProperty("#{rendezVousBean}")
	private rendezVousBean rdvBean;
	
	@ManagedProperty("#{notificationBean}")
	private notificationBean notifBean;

	@EJB
	AuthentificationServiceLocal authentificationServiceLocal;

	@EJB
	UserConnecteServiceLocal serviceConnecte;

	@EJB
	RendezVousServiceLocal rdvService;

	public String doLogin() {
		user = new User();
		user.setEmail(login);
		user.setPassword(password);

		String navigateTo = "";
		String login = authentificationServiceLocal.Login(user);
		if (login.equals("")) {

			// FacesMessage msg = new FacesMessage("Vérifier votre login et mot
			// de passe");
			// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			// FacesContext.getCurrentInstance().addMessage(null, msg);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verifier vos données.!", "Verifier vos données."));
		} else {
			userConn = serviceConnecte.lister(serviceConnecte.getUserConecte(user.getEmail()).getId());
			System.out.println(serviceConnecte.getUserConecte(user.getEmail()).getFirstName());
			System.out.println(userConn.getRole());
			loggedIn = true;
			if (serviceConnecte.lister(userConn.getId()).getRole().equals("Admin")) {

				navigateTo = "/TemplateAdmin/TemplateAdmin?faces-redirect=true";
			} else {
				System.out.println(userConn.getEmail());
				rdvBean.setUser(userConn);
				notifBean.setUser(userConn);
				navigateTo = "/template/template?faces-redirect=true";
			}
		}
		return navigateTo;
	}

	public notificationBean getNotifBean() {
		return notifBean;
	}

	public void setNotifBean(notificationBean notifBean) {
		this.notifBean = notifBean;
	}

	public String doRegister() {
		String navigateTo = "";
		String haya = "";

		if (pdf.equals(Role.Patient)) {
			User patient = new User();
			patient.setPassword(password);
			patient.setEmail(login);
			patient.setPhoneNumber(phoneNumber);
			patient.setLastName(LastName);
			patient.setFirstName(FirstName);
			patient.setPdf("Patient");
			patient.setAddress(address);

			System.out.println(patient.toString());

			String test = authentificationServiceLocal.Register(patient);

			if (test.equals("Echec")) {

				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credntials"));
				navigateTo = "/template/template?faces-redirect=true";

			} else {

				navigateTo = "/template/login?faces-redirect=true";

			}

		} else {

			User doctor = new User();
			doctor.setPassword(password);
			doctor.setEmail(login);
			doctor.setPhoneNumber(phoneNumber);
			doctor.setLastName(LastName);
			doctor.setFirstName(FirstName);
			doctor.setPdf("Doctor");
			doctor.setAddress(address);
			doctor.setOfficeAddress("1");

			System.out.println(doctor.toString());
			haya = authentificationServiceLocal.Register(doctor);

			if (haya.equals("Echec")) {

				// FacesContext.getCurrentInstance().addMessage(null,
				// new FacesMessage("Welcome " + firstname + " " + lastname));
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credntials"));
				navigateTo = "/template/template?faces-redirect=true";

			} else {
				navigateTo = "/template/login?faces-redirect=true";

			}

		}

		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/template/login?faces-redirect=true";
	}

	public rendezVousBean getRdvBean() {
		return rdvBean;
	}

	public void setRdvBean(rendezVousBean rdvBean) {
		this.rdvBean = rdvBean;
	}

	public User getUserConn() {
		return userConn;
	}

	public void setUserConn(User userConn) {
		this.userConn = userConn;
	}

	public Role getPdf() {
		return pdf;
	}

	public void setPdf(Role pdf) {
		this.pdf = pdf;
	}

	public Role[] getRoles() {

		return Role.values();
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public int getNbrPatient() {
		return nbrPatient;
	}

	public void setNbrPatient(int nbrPatient) {
		this.nbrPatient = nbrPatient;
	}

	public int getNbrDoctor() {
		return nbrDoctor;
	}

	public void setNbrDoctor(int nbrDoctor) {
		this.nbrDoctor = nbrDoctor;
	}

	
	
	
}
