package com.jerv.gendra_pt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jerv.gendra_pt.entities.CitieData;
import com.jerv.gendra_pt.repository.CitieDataDao;
import com.jerv.gendra_pt.util.IService;

/**
 * @author Josue Rivera
 *
 */
@Service
public class CitieDataService implements IService<CitieData, Long> {

	@Autowired
	private CitieDataDao dao;

	@Override
	@Transactional(readOnly = true)
	public List<CitieData> findAll() {
		return this.dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<CitieData> findAll(Pageable page) {
		return this.dao.findAll(page);
	}

	@Override
	@Transactional(readOnly = true)
	public CitieData findById(Long id) {
		return this.dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public CitieData save(CitieData citie) {
		return this.dao.save(citie);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.dao.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public CitieData findByGeonameId(Integer geonameId){
		return this.dao.findByGeonameId(geonameId);
	}

	/**
	 * @param geonameId
	 */
	@Transactional(readOnly = true)
	public boolean existInDB(Integer geonameId) {
		return this.dao.existsByGeonameId(geonameId);
	}

	@Transactional(readOnly = true)
	public List<CitieData> query(String q){
		return this.dao.findByNameOrCountryNameContaining(q,q);
	}
	
}
