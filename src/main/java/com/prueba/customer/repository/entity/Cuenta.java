package com.prueba.customer.repository.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaId;

    @Column(unique = true)
    private String numeroCuenta;

    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private BigDecimal saldoActual;
    private String estado;
}