package onetoone_uni_hibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Person_Details")
public class Person {
	@Id
	private int id;
	@Column(name = "pName")
	private String name;
	@Column(unique = true)
	private long phone;
	private String address;
	@OneToOne
	private AdharCard adharCard;


}
