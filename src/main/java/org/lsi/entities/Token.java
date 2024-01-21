package org.lsi.entities;






import javax.persistence.*;

@Entity
@Table(name = "user_tokens")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String token;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	public Token() {}
	public Token(String jwt, User user) {
		this.token = jwt;
		this.user = user;
	}
	public Token(Long  id,String token, User user) {
		super();
		this.id = id;
		this.token = token;
		this.user = user;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
