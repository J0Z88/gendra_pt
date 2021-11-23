package com.jerv.gendra_pt.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jerv.gendra_pt.entities.CitieData;
import com.jerv.gendra_pt.util.ResponseGeoNames;

/**
 * @author Josue Rivera
 *
 */

@Service
public class GeoNamesService {

	/**
	 * 
	 * @param q palabra a buscar
	 * @return Lista de aprox 100 ciudades
	 */
	public List<CitieData> search(String q) {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://api.geonames.org/searchJSON?q="+q+"&fuzzy=0.5&maxRows=100&username=josue.riveravr";
		ResponseEntity<ResponseGeoNames> response = restTemplate.getForEntity(fooResourceUrl, ResponseGeoNames.class);
		return response.getBody().getGeonames();
	}
	
}
