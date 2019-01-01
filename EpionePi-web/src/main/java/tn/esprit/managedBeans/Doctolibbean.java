package tn.esprit.managedBeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Services.StatlibService;

@ManagedBean
@SessionScoped
public class Doctolibbean {
	
	@EJB
	StatlibService statlibService ;

}
