package hibernate_Employee1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
public class EmployeeHibernate {
	
	@Id
	private int id;
	private String name;
	private double salary;
	private String dept;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private long phone;

}
