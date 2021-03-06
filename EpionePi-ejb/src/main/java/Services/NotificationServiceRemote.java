package Services;

import java.util.List;

import javax.ejb.Remote;

import Entites.EtatNotification;
import Entites.NotificationRDV;

@Remote
public interface NotificationServiceRemote 
{
	public int AddNotification(NotificationRDV n);
	public int EditEtat(EtatNotification etat,int idNotification);
	public int CalculTotalNotificationByUserSelonEtat(int idUser,EtatNotification etat);
    public List<NotificationRDV> GetNotificationByUser(int idUser);
    public List<NotificationRDV> GetNotificationByUserParEtat(int idUser,EtatNotification etat);
	public List<NotificationRDV> GetNotificationByUserEtat(int idUser, EtatNotification etat);
	public int nbrNotifNonLu(EtatNotification etat);
}
