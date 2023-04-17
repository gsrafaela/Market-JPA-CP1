package br.com.fiap.cp.entities;

import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "tb_order")
@SequenceGenerator(name="ord", sequenceName = "SQ_TB_ORDER", allocationSize = 1)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ord")
    private Long id;

    @Column(nullable = false)
    private Double totalValue;

    @CreationTimestamp
    private Calendar date;
    
    @Column
    private String status;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "tb_product", 
    
    		joinColumns = @JoinColumn(
    				name = "prod_id", 
    				referencedColumnName = "nr_product_id"
    		)/*,
    		
    		inverseJoinColumns = @JoinColumn(
    				name = "categ_id",
    				referencedColumnName = "id")*/
    		)
    private List<Product> products;
    
    @OneToOne
    private Address deliveryAddress;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Client client;

	public String getId() {

		return null;
	}

	public String getTotalValue() {
	
		return null;
	}

	public String getStatus() {
		
		return null;
	}

	public void setStatus(String closed) {

		
	}

	
}