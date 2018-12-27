package Entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Message database table.
 * 
 */
@Entity
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int msgId;

	private String content;

	private String sendingTime;

	//bi-directional many-to-one association to Discussion
	@ManyToOne
	@JoinColumn(name="idDisc")
	private Discussion discussion;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;

	public Message() {
	}

	public int getMsgId() {
		return this.msgId;
	}

	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendingTime() {
		return this.sendingTime;
	}

	public void setSendingTime(String sendingTime) {
		this.sendingTime = sendingTime;
	}

	public Discussion getDiscussion() {
		return this.discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}