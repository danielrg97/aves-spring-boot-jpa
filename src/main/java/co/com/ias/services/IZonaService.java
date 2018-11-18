package co.com.ias.services;

import java.util.List;

import co.com.ias.models.Zona;

public interface IZonaService {

	List<Zona> fetchZonas();
	Zona fetchZonaByCode(String code);
}
