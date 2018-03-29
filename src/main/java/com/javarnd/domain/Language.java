package com.javarnd.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Language")
public class Language implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "Language_Id")
	private Integer languageId;

	@Column(name = "Language_Name")
	private String languageName;

	@OneToMany(targetEntity = Country.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Country_Id", referencedColumnName = "Country_Id")
	private Set<Country> country;

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public Set<Country> getCountry() {
		return country;
	}

	public void setCountry(Set<Country> country) {
		this.country = country;
	}
}
