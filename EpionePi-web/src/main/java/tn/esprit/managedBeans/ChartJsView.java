package tn.esprit.managedBeans;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.PieChartModel;

import Services.StatlibService;


@ManagedBean
@ViewScoped
public class ChartJsView {

	@EJB
	StatlibService s;
	

	
	private PieChartModel pieModel2;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	private void createPieModels() {
		
		createPieModel2();
	}

	public void createPieModel2() {
		// pieModel2 = new PieChartModel();

		int countActif = (int) s.CountEtatCompteMActif().intValue();
		int CountSanc = (int) s.CountEtatCompteMSanctionne().intValue();
		int totale = 2;

		int pourcentageActif = (int) (countActif * 100) / totale;
		int pourcentageSanc = (int) (CountSanc * 100) / totale;

		pieModel2 = new PieChartModel();
		pieModel2.set("Actif " + pourcentageActif+ "%",pourcentageActif);
		pieModel2.set("Sanctionné " + pourcentageSanc + "%", pourcentageSanc);

		pieModel2.setTitle("Etat Des Comptes(Moral)");
		pieModel2.setLegendPosition("w");

	}

	

	public String Redirectstat() {
		return "/Admin/Chart?faces-redirect=true";
	}

}