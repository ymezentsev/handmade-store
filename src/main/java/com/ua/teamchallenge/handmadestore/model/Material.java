package com.ua.teamchallenge.handmadestore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "materials")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "material_name", unique = true, nullable = false)
    private String materialName;

}
