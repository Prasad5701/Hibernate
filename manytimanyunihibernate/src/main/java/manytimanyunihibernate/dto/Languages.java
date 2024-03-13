package manytimanyunihibernate.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Languages {

	@Id
	private int id;
	private String name;
	private String origin;
}
