package br.com.fiap.cp.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "tb_category")
@SequenceGenerator(name="ctg", sequenceName = "SQ_TB_CATEGORY", allocationSize = 1)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ctg")
    @Column(name = "nr_category_id")
    private Long id;
    
    @Column(name = "nm_category_name", nullable = false, length = 20, unique = true)
    private String name;
    
    @Column(name = "nm_category_desc", length = 200)
    private String description;
    
    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private List<Product> productList;

	public Category(long l, String string, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public char[] getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDescription(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

}