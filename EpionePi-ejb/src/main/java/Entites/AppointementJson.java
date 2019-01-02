package Entites;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppointementJson {
	private String dateAppointement;
	private String	state;
	private String reason;
	private String	patientId;
	private String doctorId;
	@JsonProperty("Analysis") 
	private String	analysis;
	private String patientBirdhday;
	private String dayRDV;
	@JsonProperty("MonthRDV")
	private String monthRDV;
	@JsonProperty("YearRDV")
	private String yearRDV;
	@JsonProperty("HourRDV")
	private String hourRDV;
	@JsonProperty("AppointementId")
		private String  appointementId;
		@JsonProperty("Diagnosis") 
		private String	diagnosis;
		private String	patientFullName;
		private String	speciality;
		@JsonProperty("TypeOfVisit")
		private String typeOfVisit;
		private String gender;
		
		private String comment;
		@JsonProperty("Patientphone")
		private String patientphone;
		private String photo;
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
		@Override
		public String toString() {
			return "AppointementJson [dateAppointement=" + dateAppointement + ", state=" + state + ", reason=" + reason
					+ ", patientId=" + patientId + ", doctorId=" + doctorId + ", analysis=" + analysis
					+ ", patientBirdhday=" + patientBirdhday + ", dayRDV=" + dayRDV + ", monthRDV=" + monthRDV
					+ ", yearRDV=" + yearRDV + ", hourRDV=" + hourRDV + ", appointementId=" + appointementId
					+ ", diagnosis=" + diagnosis + ", patientFullName=" + patientFullName + ", speciality=" + speciality
					+ ", typeOfVisit=" + typeOfVisit + ", gender=" + gender + ", comment=" + comment + ", patientphone="
					+ patientphone + ", photo=" + photo + "]";
		}
		public AppointementJson() {
			super();
		}
		
		
}
