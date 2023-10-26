package com.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_iteam")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String  id;

    @Column(name = "skucode")
    private String skuCode;

    private BigDecimal price;

    private Long quantity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;
}
