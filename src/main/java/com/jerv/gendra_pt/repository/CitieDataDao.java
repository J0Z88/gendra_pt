package com.jerv.gendra_pt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.jerv.gendra_pt.entities.CitieData;

/**
 * @author Josue Rivera
 *
 */
@Repository
public interface CitieDataDao extends RevisionRepository<CitieData, Long, Long>, JpaRepository<CitieData, Long>{

	CitieData findByGeonameId(Integer geonameId);
	
	boolean existsByGeonameId(Integer geonameId);
	
	List<CitieData> findByNameOrCountryNameContaining(String name, String countryName);
	
}
