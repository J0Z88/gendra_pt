package com.jerv.gendra_pt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jerv.gendra_pt.services.SearchCitiesService;
import com.jerv.gendra_pt.util.SuggestionsResponse;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Josue Rivera
 *
 */

@Tag(name = "Buscador de Ciudades")
@RestController
public class SearchCitiesController {

	@Autowired
	private SearchCitiesService service;

	@Hidden
	@GetMapping("/")
	public String init() {
		return "Hola copia y pega el enlace en el navegador para ir a la documentacion: https://github.com/J0Z88/gendra_pt" ;
	}
	/**
	 * Endpoint para hacer busquedas de sugerencias de ciudades
	 * 
	 * @param q:        palabra de busqueda
	 * @param latitude: latitud del usuario
	 * @param longitude longitud del usuario
	 * @return Lista de sugerencias de busqueda
	 */
	@GetMapping("/suggestions")
	@Operation(description = "Obtiene Suegrencias segun la palabra y punto geografico")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "200" ,description ="Retorna sugerencias puntuadas",
			content = { @Content(mediaType = "application/json", 
				      schema = @Schema(implementation = SuggestionsResponse.class)) }
	)
	})
	public ResponseEntity<SuggestionsResponse> search(
			@Parameter(name = "q",description = "Palabra a buscar",example = "londo, mont, mex,...") @RequestParam(required = false) String q,
			@Parameter(name = "latitude",description = "Latitud necesaria para determinar punto geografico")@RequestParam(required = false) Double latitude,
			@Parameter(name = "longitude",description = "Longitud necesaria para determinar punto geografico")@RequestParam(required = false) Double longitude){
		SuggestionsResponse response= new SuggestionsResponse(this.service.search(q,latitude,longitude));
		return new ResponseEntity<SuggestionsResponse>(response, HttpStatus.OK);
		
	}
}
