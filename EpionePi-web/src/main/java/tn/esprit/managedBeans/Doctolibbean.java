package tn.esprit.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entites.Suggestion;
import Entites.User;
import Services.StatlibService;
import Services.SuggestionService;

@ManagedBean(name="dtBasicView")
@SessionScoped
public class Doctolibbean {
	
	@EJB
	private StatlibService statlibService ;
	@EJB
	private SuggestionService ss;
	private List<User> Users;
	private User user;
	private Suggestion d = new Suggestion();
	@PostConstruct
	public void init() {
        Users = statlibService.getws1();
       
    }
	public List<User> getUsers() {
        return Users;
    }
	public Suggestion getD() {
		return d;
	}

	public void setD(Suggestion d) {
		this.d = d;
	}

	public SuggestionService getss() {
		return ss;
	}

	public void setss(SuggestionService ss) {
		this.ss = ss;
	}
 
    public void setService(StatlibService service) {
        this.statlibService = service;
    }
    
    public List<User> Getdoctaff() {
        List<User> list = new ArrayList<User>();
       list=statlibService.getws1();
         
        return list;
    }
    public String gotoone(User user) {
         
    	statlibService.getws2();
    	d.setReceiverEmail(user.getAddress());
    	d.setReceiverFirstName(user.getFirstName());
    	d.setReceiverLastName(user.getDegree());
    	ss.addSuggestion(d);
       String navigateTo = "";
       navigateTo = "/mespages/NewFile?faces-redirect=true";
       return navigateTo;
    }

}
