package co.com.ias.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ias.dao.PaisRepository;
import co.com.ias.models.Pais;

@Service
public class PaisService implements IPaisService{

	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public Pais fetchPaisByCode(String code) {
		try {
			Pais pais = paisRepository.getOne(code);
			if(pais != null) {
				return pais;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Pais> fetchPaises(){
		List<Pais> paises = new ArrayList<Pais>();
		try {
			paises = paisRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paises;
	}
}
