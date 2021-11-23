package com.jerv.gendra_pt.util;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService <T,k>{

	public List<T> findAll();
	
	public Page<T> findAll(Pageable page);
	
	public T findById(k id);
	
	public T save(T object);
	
	public void deleteById(k id);
		
}
