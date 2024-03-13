package manytimanyunihibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Data
public class Person {
	@Id
	private int id ;
	private String name;
	private long Phone;
	private String address;
	
	@ManyToMany
	private List<Languages>list;
	

}
