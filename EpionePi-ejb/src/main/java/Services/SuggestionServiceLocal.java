package Services;

import javax.ejb.Local;

import Entites.Suggestion;

@Local
public interface SuggestionServiceLocal {

	void addSuggestion(Suggestion s);

}
