package com.jerv.gendra_pt.util;

import java.util.List;

import com.jerv.gendra_pt.entities.dto.CitieDataDto;

import lombok.Data;

/**
 * @author Josue Rivera
 *
 */
@Data
public class SuggestionsResponse {
	
	private List<CitieDataDto> suggestions;

	public SuggestionsResponse(List<CitieDataDto> suggestions) {
		super();
		this.suggestions = suggestions;
	}

	
}
