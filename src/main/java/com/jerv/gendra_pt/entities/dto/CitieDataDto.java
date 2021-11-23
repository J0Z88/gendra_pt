package com.jerv.gendra_pt.entities.dto;

import java.math.BigDecimal;

import com.jerv.gendra_pt.entities.CitieData;

import lombok.Data;

/**
 * @author Josue Rivera
 *
 */
@Data
public class CitieDataDto {

	private String name;
	private Double latitud;
	private Double longitud;
	private BigDecimal score;
	
	public CitieDataDto(CitieData cd, BigDecimal score) {
		super();
		this.name = cd.getName().concat(", ").concat(cd.getAdminName1()).concat(", ").concat(cd.getCountryName());
		this.latitud = cd.getLat();
		this.longitud = cd.getLng();
		this.score = score;
	}
	
	
}
