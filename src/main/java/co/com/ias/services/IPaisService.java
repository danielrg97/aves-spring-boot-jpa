package co.com.ias.services;

import java.util.List;

import co.com.ias.models.Pais;

public interface IPaisService {

	Pais fetchPaisByCode(String code);
	List<Pais> fetchPaises();
}
