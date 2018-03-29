package com.javarnd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Sports")
public class Sports implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "Sports_Id")
	private Integer sportsId;

	@Column(name = "Sports_Name")
	private String sportsName;

	@ManyToMany(targetEntity = Country.class, cascade = CascadeType.ALL, mappedBy = "Sports")
	private Set<Country> country = new HashSet<Country>();

	public Integer getSportsId() {
		return sportsId;
	}

	public void setSportsId(Integer sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	public Set<Country> getCountry() {
		return country;
	}

	public void setCountry(Set<Country> country) {
		this.country = country;
	}

}
