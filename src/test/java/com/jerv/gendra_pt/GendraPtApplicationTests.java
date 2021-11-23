package com.jerv.gendra_pt;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.jerv.gendra_pt.entities.CitieData;
import com.jerv.gendra_pt.entities.dto.CitieDataDto;
import com.jerv.gendra_pt.util.GeoNamesUtils;
import com.jerv.gendra_pt.util.PointWSG;
import com.jerv.gendra_pt.util.SuggestionsResponse;

@SpringBootTest
class GendraPtApplicationTests {

	/**
	 * probamos clase CitieDataDto
	 */
	@Test
	void citieDataDtoTest() {
		CitieData c1= new CitieData();//objeto vacio, si construmos dto con este objeto marcara NullPointerException
		assertThrows(NullPointerException.class, () -> {new CitieDataDto(c1, BigDecimal.valueOf(0.9));});
		CitieData c2= new CitieData();//objeto con datos, veremos que al instranciar correctamente
		c2.setName("Nombre de ciudad");
		c2.setCountryName("Pais");
		c2.setAdminName1("Estado");
		c2.setLat((double)40);
		c2.setLng((double)-100);

		CitieDataDto dto = new CitieDataDto(c2,BigDecimal.valueOf(0.9));
		assertTrue(dto instanceof CitieDataDto);

	}
	
	/**
	 * Probamos clase GeoNamesUtils
	 */
	@Test
	void geoNamesUtilsTest() {
		// probamos que para cualquier punto la distancia es positiva
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
		PointWSG p1 = new PointWSG(tlr.nextDouble(-80.0, 72.0+1), tlr.nextDouble(-180.0, 180.0+1));
		PointWSG p2 = new PointWSG(tlr.nextDouble(-80.0, 72.0+1), tlr.nextDouble(-180.0, 180.0+1));
		Double distance = GeoNamesUtils.distanciaCoord(p1, p2);
		assertTrue(distance instanceof Double);
		assertTrue(distance > 0 );

		
	}
	
	/**
	 * Probamos clase SuggestionsResponse
	 */
	@Test
	void suggestionsResponseTest() {
		CitieData c= new CitieData();
		c.setName("Nombre de ciudad");
		c.setCountryName("Pais");
		c.setAdminName1("Estado");
		c.setLat((double)40);
		c.setLng((double)-100);
		List<CitieDataDto> l = new ArrayList<CitieDataDto>();
		l.add(new CitieDataDto(c,BigDecimal.valueOf(0.9)));
		SuggestionsResponse s = new SuggestionsResponse(l); 
		assertTrue(s instanceof SuggestionsResponse);
		assertTrue(s.getSuggestions().get(0) instanceof CitieDataDto);

	}
	

}
