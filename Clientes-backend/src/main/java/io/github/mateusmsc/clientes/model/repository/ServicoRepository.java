package io.github.mateusmsc.clientes.model.repository;

import io.github.mateusmsc.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
