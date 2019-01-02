package tn.esprit.managedBeans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import Entites.AppointementJson;
import Services.ServiceAppointement;


@ManagedBean
@SessionScoped
public class AppointementBean {
	private String dateAppointement;
	private String	state;
	private String reason;
	private String	patientId;
	private String doctorId;
	
	private String	analysis;
	private String patientBirdhday;
	private String dayRDV;
	
	private String monthRDV;
	
	private String yearRDV;

	private String hourRDV;

		private String  appointementId;
		
		private String	diagnosis;
		private String	patientFullName;
		private String	speciality;
		
		private String typeOfVisit;
		private String gender;
		
		private String comment;
		
		private String patientphone;
		private String photo;
		@EJB
		ServiceAppointement serviceAppointement;
		private List<AppointementJson> appointements;
		
		public List<AppointementJson> getAppointements() {
			appointements= serviceAppointement.getAppointements();
			return appointements;
		}
		public void setAppointements(List<AppointementJson> appointements) {
			this.appointements = appointements;
		}
		public String getDateAppointement() {
			return dateAppointement;
		}
		public void setDateAppointement(String dateAppointement) {
			this.dateAppointement = dateAppointement;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getReason() {
			return reason;
		}
		public void setReason(String reason) {
			this.reason = reason;
		}
		public String getPatientId() {
			return patientId;
		}
		public void setPatientId(String patientId) {
			this.patientId = patientId;
		}
		public String getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(String doctorId) {
			this.doctorId = doctorId;
		}
		public String getAnalysis() {
			return analysis;
		}
		public void setAnalysis(String analysis) {
			this.analysis = analysis;
		}
		public String getPatientBirdhday() {
			return patientBirdhday;
		}
		public void setPatientBirdhday(String patientBirdhday) {
			this.patientBirdhday = patientBirdhday;
		}
		public String getDayRDV() {
			return dayRDV;
		}
		public void setDayRDV(String dayRDV) {
			this.dayRDV = dayRDV;
		}
		public String getMonthRDV() {
			return monthRDV;
		}
		public void setMonthRDV(String monthRDV) {
			this.monthRDV = monthRDV;
		}
		public String getYearRDV() {
			return yearRDV;
		}
		public void setYearRDV(String yearRDV) {
			this.yearRDV = yearRDV;
		}
		public String getHourRDV() {
			return hourRDV;
		}
		public void setHourRDV(String hourRDV) {
			this.hourRDV = hourRDV;
		}
		public String getAppointementId() {
			return appointementId;
		}
		public void setAppointementId(String appointementId) {
			this.appointementId = appointementId;
		}
		public String getDiagnosis() {
			return diagnosis;
		}
		public void setDiagnosis(String diagnosis) {
			this.diagnosis = diagnosis;
		}
		public String getPatientFullName() {
			return patientFullName;
		}
		public void setPatientFullName(String patientFullName) {
			this.patientFullName = patientFullName;
		}
		public String getSpeciality() {
			return speciality;
		}
		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}
		public String getTypeOfVisit() {
			return typeOfVisit;
		}
		public void setTypeOfVisit(String typeOfVisit) {
			this.typeOfVisit = typeOfVisit;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public String getPatientphone() {
			return patientphone;
		}
		public void setPatientphone(String patientphone) {
			this.patientphone = patientphone;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		
		public void generateReport()
		{
			 FacesContext context   = FacesContext.getCurrentInstance();
			// String             baseURL = context.getExternalContext().getRequestContextPath();
			 String             url            = "http://localhost:18080/EpionePi-web/GeneratePdf";
			  
			 try {
			
			  context.getExternalContext().redirect(url);
			 } catch (Exception e) {
			  // Handle the exception here ...
			 } finally {
			  context.responseComplete();
			 }
			
		}
		
		
	
}
