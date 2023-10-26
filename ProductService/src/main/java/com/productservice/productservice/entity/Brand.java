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
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @GenericGenerator(strategy = "uuid2", name = "uuid2")
    private String id;
    private String brandName;
    private String description;
    private String brandRating;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "brandName")
    private List<Category> categories;
}
