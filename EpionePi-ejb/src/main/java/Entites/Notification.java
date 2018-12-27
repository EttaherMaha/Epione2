package Entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Notification database table.
 * 
 */
@Entity
@NamedQuery(name="Notification.findAll", query="SELECT n FROM Notification n")
public class Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int notificationId;

	private int appointmentId;

	private String message;

	private String objectNotification;

	//bi-directional many-to-one association to Appointment
	@ManyToOne
	private Appointment appointment;

	public Notification() {
	}

	public int getNotificationId() {
		return this.notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public int getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getObjectNotification() {
		return this.objectNotification;
	}

	public void setObjectNotification(String objectNotification) {
		this.objectNotification = objectNotification;
	}

	public Appointment getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

}