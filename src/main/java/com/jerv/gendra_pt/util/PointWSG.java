package com.jerv.gendra_pt.util;

import lombok.Data;

/**
 * @author Josue Rivera
 *
 */
@Data
public class PointWSG {

	Double lat;
	Double lng;
	
	public PointWSG(Double lat, Double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	
}
