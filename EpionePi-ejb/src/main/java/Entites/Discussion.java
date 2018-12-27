package Entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Discussion database table.
 * 
 */
@Entity
@NamedQuery(name="Discussion.findAll", query="SELECT d FROM Discussion d")
public class Discussion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDisc;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="doctorId")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="patientId")
	private User user2;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="discussion")
	private List<Message> messages;

	public Discussion() {
	}

	public int getIdDisc() {
		return this.idDisc;
	}

	public void setIdDisc(int idDisc) {
		this.idDisc = idDisc;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setDiscussion(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setDiscussion(null);

		return message;
	}

}