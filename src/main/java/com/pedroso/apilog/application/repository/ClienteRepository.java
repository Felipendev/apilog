package com.pedroso.apilog.application.repository;

import com.pedroso.apilog.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findById(Long clienteId);

    List<Cliente> findByNomeContaining(String nome);
}
