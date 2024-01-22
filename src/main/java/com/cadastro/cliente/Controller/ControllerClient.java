package com.cadastro.cliente.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cliente.DTO.ClienteRequestDTO;
import com.cadastro.cliente.DTO.ClienteResponseDTO;
import com.cadastro.cliente.Entidades.Cliente;
import com.cadastro.cliente.Repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ControllerClient {

    @Autowired
    ClienteRepository clienteRepository;

    @PostMapping("/saveCliente")
    public void saveCliente(@RequestBody ClienteRequestDTO dados) {
        Cliente clienteDados = new Cliente(dados);
        clienteRepository.save(clienteDados);
        return;
    }

    @DeleteMapping("/deletarCliente/{id}")
    public void deletar(@PathVariable String id) {
        clienteRepository.deleteById(id);
        return;
    }

    @PutMapping("/atualizarCliente/{nomeUsuario}")
    public void atualizarCliente(
        @PathVariable String nomeUsuario,
        @RequestBody ClienteRequestDTO dadosAtualizados) {

   
    if (clienteRepository.existsById(nomeUsuario)) {
        
        Cliente clienteExistente = clienteRepository.findById(nomeUsuario).orElse(null);

        
        if (clienteExistente != null) {
           clienteExistente.setNomeUsuario(dadosAtualizados.nomeUsuario());
           clienteExistente.setName(dadosAtualizados.name());
           clienteExistente.setCpf(dadosAtualizados.cpf());
           clienteExistente.setEmail(dadosAtualizados.email());
           clienteExistente.setSenha(dadosAtualizados.senha());

           clienteRepository.save(clienteExistente);
        }
     }
    }

    @GetMapping("/buscarPorId/{nomeUsuario}")
    public List<ClienteResponseDTO> exibirClienteId(@PathVariable String nomeUsuario) {
        List<ClienteResponseDTO> clienteId = clienteRepository.findById(nomeUsuario).stream()
                .map(ClienteResponseDTO::new).collect(Collectors.toList());
        return clienteId;
    }

    @GetMapping("/todos")
    public List<ClienteResponseDTO> exibirClientes() {
        List<ClienteResponseDTO> clienteList = clienteRepository.findAll().stream().map(ClienteResponseDTO::new)
                .collect(Collectors.toList());
        return clienteList;
    }
}
