package com.prueba.customer.repository.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnTransformer;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "personaId", unique = true)
    private Persona persona;

    @Column(name = "contrasena", columnDefinition = "bytea", nullable = false)
    private String contrasena;

    private Boolean estado;

}