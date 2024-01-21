package com.cadastro.cliente.Entidades;

import com.cadastro.cliente.DTO.ClienteRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Cliente")
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @Column(name = "nomeUsuario",unique = true, nullable = false, length = 50)
    private String nomeUsuario;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "cpf",length = 11)    
    private Long cpf;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "senha")
    private String senha;
    
  

    public Cliente(ClienteRequestDTO clienteDados){
        this.name  = clienteDados.name();
        this.cpf = clienteDados.cpf();
        this.nomeUsuario = clienteDados.nomeUsuario();
        this.email = clienteDados.email();
        this.senha = clienteDados.senha();
    }

}
