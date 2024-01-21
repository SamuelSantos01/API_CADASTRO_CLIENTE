package com.cadastro.cliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cadastro.cliente.Entidades.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
