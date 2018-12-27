package Entites;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the QuestionInfo database table.
 * 
 */
@Entity
@NamedQuery(name="QuestionInfo.findAll", query="SELECT q FROM QuestionInfo q")
public class QuestionInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionId;

	private String choix1;

	private String choix2;

	private String choix3;

	private String question;

	//bi-directional many-to-one association to ReponseInfo
	@OneToMany(mappedBy="questionInfo")
	private List<ReponseInfo> reponseInfos;

	public QuestionInfo() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getChoix1() {
		return this.choix1;
	}

	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}

	public String getChoix2() {
		return this.choix2;
	}

	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}

	public String getChoix3() {
		return this.choix3;
	}

	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<ReponseInfo> getReponseInfos() {
		return this.reponseInfos;
	}

	public void setReponseInfos(List<ReponseInfo> reponseInfos) {
		this.reponseInfos = reponseInfos;
	}

	public ReponseInfo addReponseInfo(ReponseInfo reponseInfo) {
		getReponseInfos().add(reponseInfo);
		reponseInfo.setQuestionInfo(this);

		return reponseInfo;
	}

	public ReponseInfo removeReponseInfo(ReponseInfo reponseInfo) {
		getReponseInfos().remove(reponseInfo);
		reponseInfo.setQuestionInfo(null);

		return reponseInfo;
	}

}