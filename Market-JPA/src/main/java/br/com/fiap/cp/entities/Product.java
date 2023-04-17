package br.com.fiap.cp.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Builder
@Table(name = "tb_product")
@SequenceGenerator(name="prd", sequenceName = "SQ_TB_PRODUCT", allocationSize = 1)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "prd")
    @Column(name = "nr_product_id")
    private Long id;

    @Column(name = "nm_product_name", nullable = false, length = 25)
    private String name;
    
    @Column(name = "ds_product_desc", nullable = false)
    private String description;
    
    @Column(name = "nr_product_price", scale = 3, precision = 2, nullable = false)
    private Double pricePerUnit;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "tb_category", 
    
    		joinColumns = @JoinColumn(
    				name = "prod_id", 
    				referencedColumnName = "nr_product_id"
    		),
    		
    		inverseJoinColumns = @JoinColumn(
    				name = "categ_id",
    				referencedColumnName = "nr_category_id")
    		)
    private List<Category> categories;
    
    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Order> orders;

	public Product(Long id, String name, String description, Double pricePerUnit, List<Category> categories,
			List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.pricePerUnit = pricePerUnit;
		this.categories = categories;
		this.orders = orders;
	}

	public Product(String string, String string2, double d, ArrayList<Order> arrayList, ArrayList<Order> arrayList2) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
