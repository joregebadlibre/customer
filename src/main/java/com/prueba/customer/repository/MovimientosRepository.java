package com.prueba.customer.repository;
import com.prueba.customer.repository.entity.Movimientos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientosRepository extends JpaRepository<Movimientos, Long> {
}