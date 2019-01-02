package Entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class NotificationRDV 
{	    
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int idNotification;
		@Temporal(TemporalType.DATE)
		private Date dateNotification;
		private String description;
		@Enumerated(EnumType.STRING)
		private TypeNotification type;
		@Enumerated(EnumType.STRING)
		private EtatNotification etat;
		private int idPatient;
		private int idDoctor;
		
		
		public int getIdNotification() {
			return idNotification;
		}
		public void setIdNotification(int idNotification) {
			this.idNotification = idNotification;
		}
		public Date getDateNotification() {
			return dateNotification;
		}
		public void setDateNotification(Date dateNotification) {
			this.dateNotification = dateNotification;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public TypeNotification getType() {
			return type;
		}
		public void setType(TypeNotification type) {
			this.type = type;
		}
		public EtatNotification getEtat() {
			return etat;
		}
		public void setEtat(EtatNotification etat) {
			this.etat = etat;
		}
		public int getIdPatient() {
			return idPatient;
		}
		public void setIdPatient(int idPatient) {
			this.idPatient = idPatient;
		}
		public int getIdDoctor() {
			return idDoctor;
		}
		public void setIdDoctor(int idDoctor) {
			this.idDoctor = idDoctor;
		}			
		
}
