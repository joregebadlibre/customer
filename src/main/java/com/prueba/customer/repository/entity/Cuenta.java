package com.prueba.customer.repository.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Cuenta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuentaId;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "clienteId")
    private Cliente cliente;

    private String numeroCuenta;
    private String tipoCuenta;
    private BigDecimal saldoInicial;
    private BigDecimal saldoActual;
    private String estado;


    @Transient
    CustomError error;
}