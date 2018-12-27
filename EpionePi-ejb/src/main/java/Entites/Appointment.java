package Entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Appointment database table.
 * 
 */
@Entity
@NamedQuery(name="Appointment.findAll", query="SELECT a FROM Appointment a")
public class Appointment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AppointementId")
	private int appointementId;

	@Column(name="Analysis")
	private String analysis;

	@Column(name="AttachementFile")
	private String attachementFile;

	private String comment;

	private boolean confirmation;

	@Column(name="ConfirmProgress")
	private boolean confirmProgress;

	private String dateAppointement;

	@Column(name="Diagnosis")
	private String diagnosis;

	private int doctorId;

	private int doctorIdReferant;

	@Column(name="Medication")
	private String medication;

	private String message;

	private int patientId;

	private String reason;

	private String report;

	private String state;

	@Column(name="TypeOfVisit")
	private String typeOfVisit;

	//bi-directional many-to-one association to MedicalRecord
	@ManyToOne
	@JoinColumn(name="medicalRecordid")
	private MedicalRecord medicalRecord;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="appointment")
	private List<Notification> notifications;

	public Appointment() {
	}

	public int getAppointementId() {
		return this.appointementId;
	}

	public void setAppointementId(int appointementId) {
		this.appointementId = appointementId;
	}

	public Object getAnalysis() {
		return this.analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getAttachementFile() {
		return this.attachementFile;
	}

	public void setAttachementFile(String attachementFile) {
		this.attachementFile = attachementFile;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean getConfirmation() {
		return this.confirmation;
	}

	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	public boolean getConfirmProgress() {
		return this.confirmProgress;
	}

	public void setConfirmProgress(boolean confirmProgress) {
		this.confirmProgress = confirmProgress;
	}

	public String getDateAppointement() {
		return this.dateAppointement;
	}

	public void setDateAppointement(String dateAppointement) {
		this.dateAppointement = dateAppointement;
	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getDoctorId() {
		return this.doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getDoctorIdReferant() {
		return this.doctorIdReferant;
	}

	public void setDoctorIdReferant(int doctorIdReferant) {
		this.doctorIdReferant = doctorIdReferant;
	}

	public String getMedication() {
		return this.medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getReport() {
		return this.report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTypeOfVisit() {
		return this.typeOfVisit;
	}

	public void setTypeOfVisit(String typeOfVisit) {
		this.typeOfVisit = typeOfVisit;
	}

	public MedicalRecord getMedicalRecord() {
		return this.medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setAppointment(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setAppointment(null);

		return notification;
	}

}