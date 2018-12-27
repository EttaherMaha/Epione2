package Entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Availibility database table.
 * 
 */
@Entity
@NamedQuery(name="Availibility.findAll", query="SELECT a FROM Availibility a")
public class Availibility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String date;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="doctorId")
	private User user;

	public Availibility() {
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}