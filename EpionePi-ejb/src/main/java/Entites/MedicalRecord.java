package Entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MedicalRecord database table.
 * 
 */
@Entity
@NamedQuery(name="MedicalRecord.findAll", query="SELECT m FROM MedicalRecord m")
public class MedicalRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int medicalRecordId;

	private String comment;

	private String reportPath;

	//bi-directional many-to-one association to Appointment
	@OneToMany(mappedBy="medicalRecord")
	private List<Appointment> appointments;

	public MedicalRecord() {
	}

	public int getMedicalRecordId() {
		return this.medicalRecordId;
	}

	public void setMedicalRecordId(int medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReportPath() {
		return this.reportPath;
	}

	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public Appointment addAppointment(Appointment appointment) {
		getAppointments().add(appointment);
		appointment.setMedicalRecord(this);

		return appointment;
	}

	public Appointment removeAppointment(Appointment appointment) {
		getAppointments().remove(appointment);
		appointment.setMedicalRecord(null);

		return appointment;
	}

}