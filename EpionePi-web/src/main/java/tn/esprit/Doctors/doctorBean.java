package tn.esprit.Doctors;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Entites.User;
import Services.DoctorsAffichageServiceLocal;

@ManagedBean(name = "doctorBean")
@SessionScoped
public class doctorBean {

	private int id;
	private String address;
	private String birthDate;
	private String education;
	private String experience;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String photo;

	private List<User> users;
	private User user;

	@EJB
	DoctorsAffichageServiceLocal serviceLocal;

	public String detailDoctor(String id) 
	{
		String navigateTo = "";
		int idUSer = Integer.parseInt(id);
		user = serviceLocal.getDoctor(idUSer);
		System.out.println(user.getId());
		System.out.println(user.getFirstName());
		navigateTo = "DetailDoctor.jsf";
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<User> getUsers() {
		users = serviceLocal.GetDoctors();
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
