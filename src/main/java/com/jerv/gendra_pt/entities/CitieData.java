package com.jerv.gendra_pt.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Data;


/**
 * @author Josue Rivera
 *
 */

@Entity@Data@Audited
@Table(name = "cities_data")
public class CitieData implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "internat_id", unique = true, nullable = false)
	private Long internatId;
	private Integer geonameId;
	private String name;
	private BigInteger population;
	private String countryName;
	private String countryCode;
	private String adminCode1;
	private String adminName1;
	private Double lat;
	private Double lng;
	private String fcodeName;
	
	
	private static final long serialVersionUID = 1L;

}
