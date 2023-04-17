package br.com.fiap.cp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {

    @Column(name = "ds_address_type",length = 20)
    private String addressType;

    @Column(name = "nm_address_street", length = 25, nullable = false)
    private String street;

    @Column(name = "nr_address_number", length = 6, nullable = false)
    private Integer number;

    @Column(name = "ds_address_complement", length = 25)
    private String complement;

    @Column(name = "nm_address_neighborhood", length = 30)
    private String neighborhood;

    @Column(name = "nm_address_city", length = 20, nullable = false)
    private String city;
    
    @OneToOne(mappedBy = "deliveryAddress")
    private Order order;

}
