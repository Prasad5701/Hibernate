package onetoonebihibernate.dto;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter

public class Person {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long phone;
	private String address;
	
	@OneToOne
	@JoinColumn
     private AdharCard card;

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address +  "]";
		
		//********Edited toString() Method,, Removed AdharCard from toString method
	} 
	
	
}
