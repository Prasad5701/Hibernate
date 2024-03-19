package manytomanybihibernate.dto;

import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cId;
	private String name;
	private long phone;
	private String address;
	
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name="sId"),inverseJoinColumns = @JoinColumn(name = "cid"))
	private List<Course>course;
		
	

}
