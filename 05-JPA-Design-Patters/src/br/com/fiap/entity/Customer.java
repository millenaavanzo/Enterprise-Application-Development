package br.com.fiap.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "T_CUSTOMER")
@Entity
@SequenceGenerator(name = "customer", sequenceName = "SQ_T_CUSTOMER", allocationSize = 1)
public class Customer {



	public Customer(String name, Calendar birthdayDate, Gender gender, byte[] profileImage) {
		super();
		this.name = name;
		this.birthdayDate = birthdayDate;
		this.gender = gender;
		this.profileImage = profileImage;
	}

	public Customer(int id, String name, Calendar birthdayDate, Gender gender, byte[] profileImage) {
		super();
		this.id = id;
		this.name = name;
		this.birthdayDate = birthdayDate;
		this.gender = gender;
		this.profileImage = profileImage;
	}

	@Id
	@Column(name = "id_customer")
	@GeneratedValue(generator = "customer", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "nm_customer", nullable = false)
	private String name;
	// pode colocar value- na frente do temporal, enum
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_birthday")
	private Calendar birthdayDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_gender")
	private Gender gender;

	@Lob
	@Column(name = "fl_profile")
	public byte[] profileImage;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(Calendar birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public byte[] getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	
	

}
