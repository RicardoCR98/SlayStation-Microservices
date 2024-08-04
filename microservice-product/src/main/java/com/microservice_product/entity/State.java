package com.microservice_product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "State")
public class State {

    @Id
    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "state_name", nullable = false, length = 15)
    private String stateName;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;

}