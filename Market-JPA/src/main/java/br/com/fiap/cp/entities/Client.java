package br.com.fiap.cp.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "tb_client")
@Builder
@SequenceGenerator(name="client", sequenceName = "SQ_TB_CLIENT", allocationSize = 1)
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "client")
	@Column(unique = true, name = "nr_client_id")
	private Integer id;
	
	@Column(name = "nm_client_name", nullable = false, length = 35)
	private String name;
	
	@Column(name = "nm_client_email", nullable = false, length = 20, unique = true)
	private String email;
	
	@Column(name = "ps_client_password", nullable = false, length = 16)
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "client")
	private List<Order> orders;
	

	public Client(int i, String string, String string2, String string3, Object object, Object object2) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.orders = orders;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
