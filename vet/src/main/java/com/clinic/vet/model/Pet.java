package com.clinic.vet.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PET")
public class Pet implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	@Column(name = "GENDER")
	private String gender;
	
	@NotNull
	@Column(name = "DATE_OF_BIRTH")
	private Date dateOfBrith;
	
	@Column(name = "ANIMAL_KIND")
	private String animalKind;
	
	@OneToOne(mappedBy = "pet")
	private DBFile dbFile;
	
	@Column(name = "WEIGHT")
	private Double weight;

	@ManyToOne(cascade =CascadeType.ALL )
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@OneToMany(mappedBy="pet",cascade =CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Visit> visits;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBrith() {
		return dateOfBrith;
	}

	public void setDateOfBrith(Date dateOfBrith) {
		this.dateOfBrith = dateOfBrith;
	}

	public String getAnimalKind() {
		return animalKind;
	}

	public void setAnimalKind(String animalKind) {
		this.animalKind = animalKind;
	}


	public DBFile getDbFile() {
		return dbFile;
	}

	public void setDbFile(DBFile dbFile) {
		this.dbFile = dbFile;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
	

}
