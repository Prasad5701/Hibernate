package onetomany_uni_hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Employee{
	
	@Id
	private int id;
	@Column(unique = true)
	private String name;
	@Column(unique = true)
	private long phone;
	private String address;
	
//	@ManyToOne
//	private Company company;

}
