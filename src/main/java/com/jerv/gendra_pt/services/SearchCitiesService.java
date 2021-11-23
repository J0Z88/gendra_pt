package com.jerv.gendra_pt.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jerv.gendra_pt.entities.CitieData;
import com.jerv.gendra_pt.entities.dto.CitieDataDto;
import com.jerv.gendra_pt.util.GeoNamesUtils;
import com.jerv.gendra_pt.util.PointWSG;

/**
 * @author Josue Rivera
 *
 */

@Service
public class SearchCitiesService {

	@Autowired
	private GeoNamesService geoNameService;
	@Autowired
	private AsyncService asyncService;
	@Autowired
	private CitieDataService citieDataService;

	/**
	 * Obtenemos sugerencias con puntuacion
	 * 
	 * @param q         : palabra clave de busqueda
	 * @param latitude
	 * @param longitude
	 */
	public List<CitieDataDto> search(String q, Double latitude, Double longitude) {
		PointWSG pUser = new PointWSG(latitude, longitude);
		List<CitieData> cities;
		cities = this.citieDataService.query(q);
		if (cities.size() < 5) {
			cities = this.geoNameService.search(q);
		}
		Double bigDistance = this.getBigDistance(cities, pUser);
		List<CitieDataDto> citiesDTO = new ArrayList<CitieDataDto>();
		List<CitieData> borrar = new ArrayList<CitieData>();
		cities.stream().map(c -> {
			if (c.getCountryCode() == null) {
				borrar.add(c);
				return c;
			}
			if (c.getName().toUpperCase().contains(q.toUpperCase())
					|| c.getCountryName().toUpperCase().contains(q.toUpperCase())) {
				citiesDTO.add(
						new CitieDataDto(c, this.getScore(pUser, new PointWSG(c.getLat(), c.getLng()), bigDistance)));
			}
			return c;
		}).collect(Collectors.toList());

		GeoNamesUtils.mayoyMenorCollector(citiesDTO);
		this.asyncService.guardarData(cities, borrar);
		return citiesDTO;

	}

	/**
	 * Comparamos distancias para obtener la mayor entre todas las ciudades y donde
	 * se encuetra el usuario
	 * 
	 * @param cities lista de ciudades
	 * @param pUser  puntoWSG del usaurio
	 * @return distancia mayor encontrada
	 */
	private Double getBigDistance(List<CitieData> cities, PointWSG pUser) {
		List<Double> result = new ArrayList<Double>();
		result.add(Double.valueOf(0));
		cities.stream().forEach(c -> {
			result.set(0,
					Math.max(result.get(0), GeoNamesUtils.distanciaCoord(pUser, new PointWSG(c.getLat(), c.getLng()))));
		});
		return result.get(0);
	}

	/**
	 * Calculamos el score
	 * 
	 * @param pUser puntoWSG del usuario
	 * @param pData puntoWSG de la ciudad analizada
	 * @return numero entre 0 y 1
	 */
	private BigDecimal getScore(PointWSG pUser, PointWSG pData, Double bigDistance) {
		return BigDecimal.valueOf(GeoNamesUtils.distanciaCoord(pUser, pData) / bigDistance)
				.setScale(1, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(-1)).add(BigDecimal.valueOf(1));
	}

}
