package pl.dawidhonorowicz.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@Column(nullable=false)
	private String city;
	private String street;
	
	@Column(name="street_number")
	private String streetNumber;
	@Column(name="apartment_number")
	private String apartmentNumber;
	
	
	
}
