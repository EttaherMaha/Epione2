package tn.esprit.managedBeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Entites.User;
import Services.AuthentificationServiceLocal;

@ManagedBean
@SessionScoped
public class AuthentificationBean 
{
	private String login;
	private String password;
	private User user;
	private boolean loggedIn;
	
	@EJB
	AuthentificationServiceLocal authentificationServiceLocal ;

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
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome " + login + " " + password));
		System.out.println("Connected");
		String navigateTo = "";
		String login = authentificationServiceLocal.Login(user);
		if (login.equals(""))
		{
			System.out.println("Erreur");
		} 
		else 
		{
			navigateTo = "/template/template?faces-redirect=true";
			loggedIn = true;
		}
		return navigateTo;
	}
	
	

}
