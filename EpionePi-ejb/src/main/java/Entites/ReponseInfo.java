package Entites;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ReponseInfo database table.
 * 
 */
@Entity
@NamedQuery(name="ReponseInfo.findAll", query="SELECT r FROM ReponseInfo r")
public class ReponseInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int reponseId;

	private int patientId;

	private String reponse;

	//bi-directional many-to-one association to QuestionInfo
	@ManyToOne
	@JoinColumn(name="questionId")
	private QuestionInfo questionInfo;

	public ReponseInfo() {
	}

	public int getReponseId() {
		return this.reponseId;
	}

	public void setReponseId(int reponseId) {
		this.reponseId = reponseId;
	}

	public int getPatientId() {
		return this.patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getReponse() {
		return this.reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public QuestionInfo getQuestionInfo() {
		return this.questionInfo;
	}

	public void setQuestionInfo(QuestionInfo questionInfo) {
		this.questionInfo = questionInfo;
	}

}