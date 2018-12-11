package com.qa.thain.alex.garage.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Vehicle")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "creationDate", "lastModified" }, allowGetters = true)
public class GarageAppModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String vMake;
	
	@NotBlank
	private String vModel;
	
	@NotBlank
	private String vRegistrationNumber;
	
	@NotBlank
	private String vType;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date creationDate;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModified;
	
	public Long getId() {
		return this.id;
	}	
	public void setId(Long id)	{
		this.id = id;
	}
	public String getvMake() {
		return this.vMake;
	}
	public void setvMake(String vMake) {
		this.vMake = vMake;
	}	
	public String getvModel() {
		return this.vModel;
	}		
	public void setvModel(String vModel) {	
		this.vModel = vModel;
	}	
	public String getvRegistrationNumber() {
		return this.vRegistrationNumber;
	}	
	public void setvRegistrationNumber(String vRegistrationNumber) {
		this.vRegistrationNumber = vRegistrationNumber;
	}	
	public Date getCreationDate() {
		return this.creationDate;
	}	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}	
	public Date getLastModified() {	
		return this.lastModified;
	}
	public void setLastModified(Date lastModified) {	
		this.lastModified = lastModified;
	}
	public String getvType() {
		return this.vType;
	}
	public void setvType(String vType) {
		this.vType = vType;
	}
}