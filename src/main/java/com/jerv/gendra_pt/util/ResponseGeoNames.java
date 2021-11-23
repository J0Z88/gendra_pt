package com.jerv.gendra_pt.util;

import java.math.BigInteger;
import java.util.List;

import com.jerv.gendra_pt.entities.CitieData;

import lombok.Data;

/**
 * @author Josue Rivera
 *
 */
@Data
public class ResponseGeoNames {

	private BigInteger totalResultsCount;
	private List<CitieData> geonames;
}
