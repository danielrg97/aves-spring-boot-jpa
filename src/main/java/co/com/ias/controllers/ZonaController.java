package co.com.ias.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.ias.models.Zona;
import co.com.ias.services.ZonaService;

@Controller
@RequestMapping("/zones")
public class ZonaController {

	@Autowired
	private ZonaService zonaService;
	
	@GetMapping
	public @ResponseBody List<Zona> fetchZones(){
		return zonaService.fetchZonas();
	}
	
	@GetMapping(value="/{code}")
	public @ResponseBody Zona fetchZoneByCode(@PathVariable("code") String code){
		return zonaService.fetchZonaByCode(code);
	}
}
