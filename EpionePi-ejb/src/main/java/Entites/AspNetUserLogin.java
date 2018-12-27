package Entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AspNetUserLogins database table.
 * 
 */
@Entity
@Table(name="AspNetUserLogins")
@NamedQuery(name="AspNetUserLogin.findAll", query="SELECT a FROM AspNetUserLogin a")
public class AspNetUserLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AspNetUserLoginPK id;

	public AspNetUserLogin() {
	}

	public AspNetUserLoginPK getId() {
		return this.id;
	}

	public void setId(AspNetUserLoginPK id) {
		this.id = id;
	}

}