package com.jerv.gendra_pt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.jerv.gendra_pt.entities.CitieData;

/**
 * @author Josue Rivera
 *
 */
@Service
public class AsyncService {

	@Autowired
	private CitieDataService citieDataService;
	


	/**
	 * @param cities lista de ciudades
	 * @param borrar lista de ciudades a borrar
	 */
	@Async
	public void guardarData(List<CitieData> cities, List<CitieData> borrar) {
		cities.removeIf(x -> borrar.contains(x));//borrarmos los tados previamente capturados
		// iteramos las ciudades
		cities.stream().forEach(c -> {
			// verificamos que no exista en BD para guardar
			if(!this.citieDataService.existInDB(c.getGeonameId())) {
				this.citieDataService.save(c);
			}
		});
		
	}
}
