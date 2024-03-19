package manytooneunihibernate.dto;

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
public class Student {

	@Id
	private int id;
	private String name;
	private String dept;
	private long phone;
	
	@ManyToOne
	private College college;
}
