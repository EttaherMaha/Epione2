package Entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	@Column(name="AccessFailedCount")
	private int accessFailedCount;

	private String address;

	private String birthDate;

	private String confirmation;

	private String degree;

	private String education;

	@Column(name="Email")
	private String email;

	@Column(name="EmailConfirmed")
	private boolean emailConfirmed;

	private String experience;

	@Column(name="FirstName")
	private String firstName;

	private String gender;

	@Column(name="LastName")
	private String lastName;

	@Column(name="LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name="LockoutEndDateUtc")
	private String lockoutEndDateUtc;

	@Column(name="Login")
	private String login;

	@Column(name="MDP")
	private String mdp;

	private String officeAddress;

	private String password;

	private String pdf;

	@Column(name="PhoneNumber")
	private String phoneNumber;

	@Column(name="PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	private String photo;

	private String role;

	@Column(name="SecurityStamp")
	private String securityStamp;

	@Column(name="TwoFactorEnabled")
	private boolean twoFactorEnabled;

	//bi-directional many-to-one association to Availibility
	@OneToMany(mappedBy="user")
	private List<Availibility> availibilities;

	//bi-directional many-to-one association to CustomUserClaim
	@OneToMany(mappedBy="user")
	private List<CustomUserClaim> customUserClaims;

	//bi-directional many-to-one association to CustomUserLogin
	@OneToMany(mappedBy="user")
	private List<CustomUserLogin> customUserLogins;

	//bi-directional many-to-one association to Discussion
	@OneToMany(mappedBy="user1")
	private List<Discussion> discussions1;

	//bi-directional many-to-one association to Discussion
	@OneToMany(mappedBy="user2")
	private List<Discussion> discussions2;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user")
	private List<Message> messages;

	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="user")
	private List<Skill> skills;

	//bi-directional many-to-one association to Suggestion
	@OneToMany(mappedBy="user")
	private List<Suggestion> suggestions;

	//bi-directional many-to-one association to Speciality
	@ManyToOne
	@JoinColumn(name="specialityId")
	private Speciality speciality;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getConfirmation() {
		return this.confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public String getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(String lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getOfficeAddress() {
		return this.officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPdf() {
		return this.pdf;
	}

	public void setPdf(String pdf) {
		this.pdf = pdf;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public List<Availibility> getAvailibilities() {
		return this.availibilities;
	}

	public void setAvailibilities(List<Availibility> availibilities) {
		this.availibilities = availibilities;
	}

	public Availibility addAvailibility(Availibility availibility) {
		getAvailibilities().add(availibility);
		availibility.setUser(this);

		return availibility;
	}

	public Availibility removeAvailibility(Availibility availibility) {
		getAvailibilities().remove(availibility);
		availibility.setUser(null);

		return availibility;
	}

	public List<CustomUserClaim> getCustomUserClaims() {
		return this.customUserClaims;
	}

	public void setCustomUserClaims(List<CustomUserClaim> customUserClaims) {
		this.customUserClaims = customUserClaims;
	}

	public CustomUserClaim addCustomUserClaim(CustomUserClaim customUserClaim) {
		getCustomUserClaims().add(customUserClaim);
		customUserClaim.setUser(this);

		return customUserClaim;
	}

	public CustomUserClaim removeCustomUserClaim(CustomUserClaim customUserClaim) {
		getCustomUserClaims().remove(customUserClaim);
		customUserClaim.setUser(null);

		return customUserClaim;
	}

	public List<CustomUserLogin> getCustomUserLogins() {
		return this.customUserLogins;
	}

	public void setCustomUserLogins(List<CustomUserLogin> customUserLogins) {
		this.customUserLogins = customUserLogins;
	}

	public CustomUserLogin addCustomUserLogin(CustomUserLogin customUserLogin) {
		getCustomUserLogins().add(customUserLogin);
		customUserLogin.setUser(this);

		return customUserLogin;
	}

	public CustomUserLogin removeCustomUserLogin(CustomUserLogin customUserLogin) {
		getCustomUserLogins().remove(customUserLogin);
		customUserLogin.setUser(null);

		return customUserLogin;
	}

	public List<Discussion> getDiscussions1() {
		return this.discussions1;
	}

	public void setDiscussions1(List<Discussion> discussions1) {
		this.discussions1 = discussions1;
	}

	public Discussion addDiscussions1(Discussion discussions1) {
		getDiscussions1().add(discussions1);
		discussions1.setUser1(this);

		return discussions1;
	}

	public Discussion removeDiscussions1(Discussion discussions1) {
		getDiscussions1().remove(discussions1);
		discussions1.setUser1(null);

		return discussions1;
	}

	public List<Discussion> getDiscussions2() {
		return this.discussions2;
	}

	public void setDiscussions2(List<Discussion> discussions2) {
		this.discussions2 = discussions2;
	}

	public Discussion addDiscussions2(Discussion discussions2) {
		getDiscussions2().add(discussions2);
		discussions2.setUser2(this);

		return discussions2;
	}

	public Discussion removeDiscussions2(Discussion discussions2) {
		getDiscussions2().remove(discussions2);
		discussions2.setUser2(null);

		return discussions2;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setUser(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setUser(null);

		return message;
	}

	public List<Skill> getSkills() {
		return this.skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Skill addSkill(Skill skill) {
		getSkills().add(skill);
		skill.setUser(this);

		return skill;
	}

	public Skill removeSkill(Skill skill) {
		getSkills().remove(skill);
		skill.setUser(null);

		return skill;
	}

	public List<Suggestion> getSuggestions() {
		return this.suggestions;
	}

	public void setSuggestions(List<Suggestion> suggestions) {
		this.suggestions = suggestions;
	}

	public Suggestion addSuggestion(Suggestion suggestion) {
		getSuggestions().add(suggestion);
		suggestion.setUser(this);

		return suggestion;
	}

	public Suggestion removeSuggestion(Suggestion suggestion) {
		getSuggestions().remove(suggestion);
		suggestion.setUser(null);

		return suggestion;
	}

	public Speciality getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

}