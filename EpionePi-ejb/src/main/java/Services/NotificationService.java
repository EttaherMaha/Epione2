package Services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Entites.EtatNotification;
import Entites.NotificationRDV;

/**
 * Session Bean implementation class NotificationService
 */
@Stateless
public class NotificationService implements NotificationServiceRemote, NotificationServiceLocal {
	@PersistenceContext(unitName = "EpionePi-ejb")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public NotificationService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int AddNotification(NotificationRDV n) {
		em.persist(n);
		return n.getIdNotification();
	}

	@Override
	public int EditEtat(EtatNotification etat, int idNotification) {
		return em.createQuery("UPDATE NotificationRDV SET etat= :etat where idNotification= :id")
				.setParameter("etat", etat).setParameter("id", idNotification).executeUpdate();
	}

	@Override
	public int CalculTotalNotificationByUserSelonEtat(int idUser, EtatNotification etat) {
		Long lol = em
				.createQuery("select count(r) from NotificationRDV r  where idDoctor= :ID and etat= :etat", Long.class)
				.setParameter("ID", idUser).setParameter("etat", etat).getSingleResult();
		return lol.intValue();
	}

	@Override
	public List<NotificationRDV> GetNotificationByUser(int idUser) {
		return em.createQuery(" select c from NotificationRDV c where idDoctor= :id order By dateNotification DESC",
				NotificationRDV.class).setParameter("id", idUser).getResultList();
	}

	@Override
	public List<NotificationRDV> GetNotificationByUserParEtat(int idUser, EtatNotification etat) {
		return em.createQuery(
				" select c from NotificationRDV c where idDoctor= :id and etat= :etat order By dateNotification DESC",
				NotificationRDV.class).setParameter("id", idUser).setParameter("etat", etat).getResultList();
	}

	@Override
	public List<NotificationRDV> GetNotificationByUserEtat(int idUser, EtatNotification etat) {
		return em
				.createQuery(
						" select c from NotificationRDV c where idDoctor=:id and etat=:etat order By dateNotification DESC",
						NotificationRDV.class)
				.setParameter("id", idUser).setParameter("etat", EtatNotification.NonLu).getResultList();
	}
}
