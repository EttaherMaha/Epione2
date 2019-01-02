package Services;

import java.util.List;

import javax.ejb.Local;

import Entites.AppointementJson;

@Local
public interface AppointementLocal {
	public List<AppointementJson> getAppointements();
	public List <AppointementJson> getAppointementByMedicalRecord(int id);
	public AppointementJson getAppointement(int id);
	public void generatePdf();

}
