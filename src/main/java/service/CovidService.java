package service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CovidService {
	
	private static final String url = "https://corona-virus-world-and-india-data.p.rapidapi.com/api";
	
	private static final String XRapidAPIKey = "f0a978666bmshad15da9e9f75d4ep17bb2cjsne1f9acd28553";
	
	private static final String XRapidAPIHost = "corona-virus-world-and-india-data.p.rapidapi.com";
	
	@Autowired
	private RestTemplate restTemplate;

	public Object getAllCountryCovidData() {
		try {
			//Header Value Is Set
			HttpHeaders headers = new HttpHeaders();
			headers.set("X-RapidAPI-Key", "f0a978666bmshad15da9e9f75d4ep17bb2cjsne1f9acd28553");
			headers.set("X-RapidAPI-Host", "corona-virus-world-and-india-data.p.rapidapi.com");
			
			
			//Make a get  call to rapidAPI
			
			ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,new HttpEntity<>(headers), String.class);
			
		}catch (Exception e) {
			//log.error("somthing went wrong while getting value from api",e); 
//		 Log.error("Something went wrong!", e);
			
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR,
					"Exception while calling endpoint of api for corona", e
					);
		}
	}
}
