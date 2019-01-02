package Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Entites.Suggestion;

@Stateless
@LocalBean
public class SuggestionService implements SuggestionServiceLocal,SuggestionServiceRemote    {

	@PersistenceContext(unitName = "EpionePi-ejb")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public SuggestionService() {
        
    }
    @Override
    public void addSuggestion(Suggestion s) {
    	//utx.begin();
    
		em.persist(s);
	//	utx.commit();
}
	@Override
	public List<Suggestion> getall() {
		Query jpql = em.createQuery("select a from Suggestion a");
		return jpql.getResultList();
	}
}
