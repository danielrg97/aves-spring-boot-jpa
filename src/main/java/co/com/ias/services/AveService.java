package co.com.ias.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ias.dao.AveRepository;
import co.com.ias.models.Ave;
import co.com.ias.models.Pais;
import co.com.ias.utils.ResponseMessage;
import co.com.ias.utils.ResponseMessageHandler;

@Service
public class AveService implements IAveService{

	@Autowired
	private AveRepository aveRepository;		
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private ResponseMessageHandler responseHandler;
	
	@Override
	public List<Ave> fetchAves(){
		List<Ave> aves = new ArrayList<Ave>();
		try {
			aves = aveRepository.findAll();
			aves = aves.stream()
					.filter(ave -> !ave.getIsRemove())
					.collect(Collectors.toList());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return aves;
	}
	
	@Override
	public Ave fetchAveByCode(String code) {
		try {
			Optional<Ave> aveExist = aveRepository.findById(code);
			if(aveExist.isPresent()) {
				return aveExist.get();
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	@Override
	public List<Ave> fetchAvesByZonaAndNombre(String nombreAve, String codeZona){
		List<Ave> aves = new ArrayList<Ave>();			
		List<Pais> paises = new ArrayList<Pais>();
		try {
//			aves = aveRepository.fetchAvesContainingName(nombreAve, codeZona);
			if (nombreAve != null) {
	            aves = aves.stream()
	                    .filter(a -> a.getNombreComun().contains(nombreAve) || a.getNombreCientifico().contains(nombreAve))
	                    .collect(Collectors.toList());
	        }
	        if (codeZona != null) {
	            paises = paisService.fetchPaises().stream()
	                    .filter(paisAves -> paisAves.getZona().getCodigo().equals(codeZona))
	                    .collect(Collectors.toList());
	            
	            for (Pais pais : paises) {
					for(Ave ave : pais.getAves()) {
						if(!aves.contains(ave)) {
							aves.add(ave);
						}
					}
				}	            
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aves;
	}
	
	@Override
	public ResponseMessage addAve(Ave ave) {
		ResponseMessage response = new ResponseMessage();
		try {
			if(ave.getCodigoPais() != null) {
				Pais pais = paisService.fetchPaisByCode(ave.getCodigoPais());
				if(pais != null) {
					ave.addPais(pais);
				}
			}
			aveRepository.save(ave);
			response = responseHandler.showCreateSuccessMessage();
		} catch (Exception e) {
			response = responseHandler.showCreateErrorMessage();
			e.printStackTrace();
		}		
		return response;
	}
	
	@Override
	public ResponseMessage updateAve(Ave ave) {
		ResponseMessage response = new ResponseMessage();
		try {
			Ave aveExist = fetchAveByCode(ave.getCodigo());
			if(aveExist != null) {
				aveExist.setNombreCientifico(ave.getNombreCientifico());
				aveExist.setNombreComun(ave.getNombreComun());
				aveExist.setPaises(ave.getPaises());
				aveRepository.save(aveExist);
				response = responseHandler.showUpdateSuccessMessage();
			}else {
				response = responseHandler.showNotFoundMessage();
			}
		} catch (Exception e) {
			response = responseHandler.showUpdateErrorMessage();
			e.printStackTrace();
		}
		return response;
	}
	
	@Override
	public ResponseMessage deleteAve(String code) {
		ResponseMessage response = new ResponseMessage();
		try {
			Ave aveExist = fetchAveByCode(code);
			if(aveExist != null) {
				aveExist.setIsRemove(true);
				aveRepository.save(aveExist);
				response = responseHandler.showDeleteSuccessMessage();
			}else {
				response = responseHandler.showNotFoundMessage();
			}
		} catch (Exception e) {
			response = responseHandler.showDeleteErrorMessage();
			e.printStackTrace();
		}
		return response;
	}	
}
