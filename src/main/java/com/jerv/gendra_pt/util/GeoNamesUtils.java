package com.jerv.gendra_pt.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.jerv.gendra_pt.entities.dto.CitieDataDto;

/**
 * @author Josue Rivera
 *
 */
public class GeoNamesUtils {

	/**
	 * Calculamos distancia entre dos puntos
	 * @param pointUser
	 * @param pointData
	 * @return distancia en kilometros
	 */
	public static Double distanciaCoord(PointWSG pointUser,PointWSG pointData) {
		Double radioTierra = 6431.805538;// kilometros  
		Double dLat = Math.toRadians(pointData.getLat() - pointUser.getLat());  
		Double dLng = Math.toRadians(pointData.getLng() - pointUser.getLng());  
		Double sindLat = Math.sin(dLat / 2);  
		Double sindLng = Math.sin(dLng / 2);  
		Double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2) * 
				Math.cos(Math.toRadians(pointUser.getLat())) * Math.cos(Math.toRadians(pointData.getLat()));  
		Double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
		Double distancia = radioTierra * va2;  
   
        return distancia; 
	}

	/**
	 * @param citiesDTO
	 */
	public static void mayoyMenorCollector(List<CitieDataDto> citiesDTO) {
		Collections.sort(citiesDTO, new Comparator<CitieDataDto>() {
			@Override
			public int compare(CitieDataDto p1, CitieDataDto p2) {
				return p2.getScore().compareTo(p1.getScore());
			}
		});		
	}
	
	
}
