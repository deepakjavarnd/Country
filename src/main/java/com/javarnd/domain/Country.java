package com.javarnd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "Country_Id")
	private Long countryId;

	@Column(name = "Country_Name")
	private String countryName;

	@OneToOne(targetEntity = Language.class, cascade = CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name = "Language_Id", referencedColumnName = "Language_Id")
	private Language language;

	@OneToOne(targetEntity = Language.class, cascade = CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name = "City_Id", referencedColumnName = "City_Id")
	private City city;

	@ManyToMany(targetEntity = Sports.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "Country_Sports", joinColumns = @JoinColumn(name = "Country_Id", referencedColumnName = "Country_Id"), inverseJoinColumns = @JoinColumn(name = "Sports_Id", referencedColumnName = "Sports_Id"))
	private Set<Sports> spots = new HashSet<Sports>();

	public Set<Sports> getSpots() {
		return spots;
	}

	public void setSpots(Set<Sports> spots) {
		this.spots = spots;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
