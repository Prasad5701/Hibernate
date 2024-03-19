package manytooneunihibernate.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class College {

	@Id
	private int id;
	private String name;
	private String city;

}
