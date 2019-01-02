package Services;

import javax.ejb.Remote;

import Entites.Suggestion;

@Remote
public interface SuggestionServiceRemote {
	void addSuggestion(Suggestion s);
}
