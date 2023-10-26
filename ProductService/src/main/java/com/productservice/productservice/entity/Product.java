package com.productservice.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(strategy = "uuid2", name = "uuid2")
    @Column(length = 36, name = "id", updatable = false, nullable = false)
    private String id;
    private String name;
    private String price;
    private String description;
    private String customAttributes;
    private Boolean availability;
    private String metadata;
    private List<String> productImages;
    private List<String>  review;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="parent_product_id")
    private List<Product> relatedProducts;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
}
