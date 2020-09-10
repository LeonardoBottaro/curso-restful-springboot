package com.example.aula_lab_noite_27_08_2020.controller;

import java.util.List;

import com.example.aula_lab_noite_27_08_2020.model.Cliente;
import com.example.aula_lab_noite_27_08_2020.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return repository.getAllClientes();
    }

    @GetMapping("/clientes/{codigo}")
    public Cliente getClientes(@PathVariable int codigo) {
        return repository.getClienteByCodigo(codigo);
    }

    @PostMapping("/clientes")
    public Cliente salvar(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }
}