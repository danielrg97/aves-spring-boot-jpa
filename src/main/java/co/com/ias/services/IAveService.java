package co.com.ias.services;

import java.util.List;

import co.com.ias.models.Ave;
import co.com.ias.utils.ResponseMessage;

public interface IAveService {

	List<Ave> fetchAves();
	Ave fetchAveByCode(String code);
	List<Ave> fetchAvesByZonaAndNombre(String nombreAve, String codeZona);
	ResponseMessage addAve(Ave ave);
	ResponseMessage updateAve(Ave ave);
	ResponseMessage deleteAve(String code);
}
