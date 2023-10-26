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
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(strategy = "uuid2", name = "uuid2")
    private String id;

    private String name;
    private String description;

    @OneToMany(cascade =CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "category")
    private List<Product> product;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "category_brand",
    joinColumns = @JoinColumn(name = "category_id"),
    inverseJoinColumns = @JoinColumn( name = "brand_id"))
    private List<Brand> brandName;


}
