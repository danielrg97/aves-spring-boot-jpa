package co.com.ias.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ias.dao.ZonaRepository;
import co.com.ias.models.Zona;

@Service
public class ZonaService implements IZonaService{

	@Autowired
	private ZonaRepository zonaRepository;
	
	@Override
	public List<Zona> fetchZonas(){
		List<Zona> zonas = new ArrayList<Zona>();
		try {
			zonas = zonaRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return zonas;
	}
	
	@Override
	public Zona fetchZonaByCode(String code) {		
		try {
			Optional<Zona> zona = zonaRepository.findById(code);
			if(zona.isPresent()) {				
				return zona.get();
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
