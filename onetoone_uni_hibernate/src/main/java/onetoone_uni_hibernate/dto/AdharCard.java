package onetoone_uni_hibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class AdharCard{
	@Id
	private int id;
	private String name;
	private String address;
	
	

}
