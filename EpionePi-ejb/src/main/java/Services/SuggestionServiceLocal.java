package Services;

import java.util.List;

import javax.ejb.Local;

import Entites.Suggestion;

@Local
public interface SuggestionServiceLocal {

	void addSuggestion(Suggestion s);
	public List<Suggestion> getall ();

}
