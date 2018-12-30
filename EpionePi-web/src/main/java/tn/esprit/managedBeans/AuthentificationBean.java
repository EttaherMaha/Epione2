package tn.esprit.managedBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entites.User;
import Services.AuthentificationServiceLocal;
import Services.UserConnecteService;
import Services.UserConnecteServiceLocal;
 
@ManagedBean
@SessionScoped
public class AuthentificationBean 
{
	private String login;
	private String password;
	private User user;
	private User userConn;
	private boolean loggedIn = false;
	
	@EJB
	AuthentificationServiceLocal authentificationServiceLocal ;

	@EJB
	UserConnecteServiceLocal serviceConnecte;
	
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
	
	
	public String doLogin()
	{
		user = new User();
		user.setEmail(login);
		user.setPassword(password);
				
		String navigateTo = "";
		String login = authentificationServiceLocal.Login(user);
		if (login.equals(""))
		{
		
			//FacesMessage msg = new FacesMessage("Vérifier votre login et mot de passe");
			//msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			//FacesContext.getCurrentInstance().addMessage(null, msg);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verifier vos données.!", "Verifier vos données."));		
		} 
		else 
		{
			userConn = serviceConnecte.getUserConecte(user.getEmail());
			System.out.println(serviceConnecte.getUserConecte(user.getEmail()).getFirstName());
			loggedIn = true;
			if (serviceConnecte.lister(userConn.getId()).getRole().equals("Admin")) 
			{

				navigateTo = "/TemplateAdmin/TemplateAdmin?faces-redirect=true";
			}
			else 
			{
				navigateTo = "/template/template?faces-redirect=true";

			}
		}
		return navigateTo;
	}
	


	public User getUserConn() {
		return userConn;
	}

	public void setUserConn(User userConn) {
		this.userConn = userConn;
	}

	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/template/login?faces-redirect=true";
	}
	

}
