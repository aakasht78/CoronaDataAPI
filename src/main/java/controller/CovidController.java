package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.CovidService;

@RestController
@RequestMapping("/covid")
public class CovidController {

	private final CovidService covidService;
	
	@GetMapping("/get-all-country-covid-data")
	public ResponseEntity<?> callRapidEndpointToGetCovidData(){
		return ResponseEntity.ok(covidService.getAllCountryCovidData());
	}
}
