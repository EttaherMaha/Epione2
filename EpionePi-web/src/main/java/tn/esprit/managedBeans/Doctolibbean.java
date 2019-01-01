package tn.esprit.managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entites.User;
import Services.StatlibService;

@ManagedBean(name="dtBasicView")
@SessionScoped
public class Doctolibbean {
	
	@EJB
	private StatlibService statlibService ;
	private List<User> Users;
	private User user;
	@PostConstruct
	public void init() {
        Users = statlibService.getws1();
       
    }
	public List<User> getUsers() {
        return Users;
    }
 
    public void setService(StatlibService service) {
        this.statlibService = service;
    }
    
    public List<User> Getdoctaff() {
        List<User> list = new ArrayList<User>();
       list=statlibService.getws1();
         
        return list;
    }
    public String gotoone() {
         
    	
       String navigateTo = "";
       navigateTo = "/mespages/NewFile?faces-redirect=true";
       return navigateTo;
    }

}
