package org.lsi.entities;

import java.math.BigInteger;






import javax.persistence.*;

@Entity
@Table(name = "contracts")
public class Contract{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "buyer_user_id")
	private User buyer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seller_user_id")
	private User seller;

	private BigInteger cost;
	private String date;

	@ManyToOne
	@JoinColumn(name = "property_id")
	private Proprety prop; // Corrected typo in Property class name

	private String descc;

	
	public Contract() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contract(Long id, User buyer, User seller, BigInteger cost, String date, Proprety prop, String desc) {
		super();
		this.id = id;
		this.buyer = buyer;
		this.seller = seller;
		this.cost = cost;
		this.date = date;
		this.prop = prop;
		this.descc = desc;
	}
	
	

	public Contract(User buyer, User seller, BigInteger cost, String date, Proprety prop, String desc) {
		super();
		this.buyer = buyer;
		this.seller = seller;
		this.cost = cost;
		this.date = date;
		this.prop = prop;
		this.descc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public BigInteger getCost() {
		return cost;
	}

	public void setCost(BigInteger cost) {
		this.cost = cost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Proprety getProp() {
		return prop;
	}

	public void setProp(Proprety prop) {
		this.prop = prop;
	}

	public String getDesc() {
		return descc;
	}

	public void setDesc(String desc) {
		this.descc = desc;
	}

	
}
