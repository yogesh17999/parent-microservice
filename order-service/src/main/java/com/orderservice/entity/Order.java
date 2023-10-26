package com.orderservice.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_order")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "order")
    private List<OrderLineItem> orderLineItems;
}
