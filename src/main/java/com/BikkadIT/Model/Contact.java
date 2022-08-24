package com.BikkadIT.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "CONTACT_DTLS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Contact {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTACT_ID")
	private int cId;
	@Column(name = "CONTACT_NAME")
	private String cName;
	@Column(name = "CONTACT_NUMBER")
	private String cNumber;
	@Column(name = "CONTACT_EMAIL")
	private String email;
	@Column(name = "ACTIVE_SWITCH")
	private Character activeSwitch;
	@Column(name = "CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	@Column(name = "UPDATED_DATE",insertable = false)
	private LocalDate updateDate;
	
	
}
