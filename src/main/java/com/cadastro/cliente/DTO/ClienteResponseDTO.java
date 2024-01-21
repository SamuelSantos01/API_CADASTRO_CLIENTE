package com.cadastro.cliente.DTO;

import com.cadastro.cliente.Entidades.Cliente;

public record ClienteResponseDTO(String nomeUsuario, String name, String email) {
    
    public ClienteResponseDTO(Cliente cliente){
        this( cliente.getNomeUsuario(), cliente.getName(), cliente.getEmail());
    }
}
