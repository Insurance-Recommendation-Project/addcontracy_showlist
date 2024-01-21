package org.lsi.entities;




import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private ERole name;
	

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, ERole name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId_role() {
		return id;
	}

	public void setId_role(Long id) {
		this.id = id;
	}

	public ERole getName() {
		return name;
	}

	public void setName(ERole name) {
		this.name = name;
	}

}
