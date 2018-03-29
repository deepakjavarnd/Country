package com.javarnd.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "City_Id")
	private Integer cityId;

	@Column(name = "City_Name")
	private String cityName;

	@OneToOne(targetEntity = Country.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "Country_Id", referencedColumnName = "Country_Id")
	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
