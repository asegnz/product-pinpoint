package com.asegnz.product.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    @Getter
    private Long id;

    @NotNull
    @Column
    @Getter @Setter
    private String productName;

    @NotNull
    @Column
    @Getter @Setter
    private String description;

    @NotNull
    @Column
    @Getter @Setter
    private Float price;

    @NotNull
    @Column
    @Getter @Setter
    private Integer quantity;

    public static Product productWithId(Product product, Long id) {
        return new Product(id, product.getProductName(), product.getDescription(), product.getPrice(), product.getQuantity());
    }

}
