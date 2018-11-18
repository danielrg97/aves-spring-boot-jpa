package co.com.ias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ias.beans.SearchAveBean;
import co.com.ias.models.Ave;
import co.com.ias.services.AveService;
import co.com.ias.utils.ResponseMessage;

@RestController
@RequestMapping("/birds")
public class AveController {

	@Autowired
	private AveService aveService;
	
	@GetMapping
	public List<Ave> fetchAves(){
		return aveService.fetchAves();
	}
	
	@GetMapping(value="/{code}", produces="application/json")
	public Ave fetchAveByCode(@PathVariable("code") String code) {
		return aveService.fetchAveByCode(code);
	}
	
	@PostMapping(value="/fetchAvesByZonaAndNombre")
	public List<Ave> fetchAvesByZonaAndNombre(@RequestBody SearchAveBean filter){
		return aveService.fetchAvesByZonaAndNombre(filter.getNombre(), filter.getZona());
	}
	
	@PostMapping
	public ResponseMessage addAve(@RequestBody Ave ave){
		return aveService.addAve(ave);		
	}	
	
	@PutMapping
	public ResponseMessage updateAve(@RequestBody Ave ave) {
		return aveService.updateAve(ave);
	}
	
	@DeleteMapping(value="/{code}")
	public ResponseMessage deleteAve(@PathVariable("code") String code) {
		return aveService.deleteAve(code);
	}
}
