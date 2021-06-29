package io.github.mateusmsc.clientes.model.repository;

import io.github.mateusmsc.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}