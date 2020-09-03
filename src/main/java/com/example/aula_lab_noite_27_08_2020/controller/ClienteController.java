package com.example.aula_lab_noite_27_08_2020.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    List <Cliente> clientes;

    @PostConstruct
    public void criarClientes(){
        final Cliente c1 = new Cliente();
        final Cliente c2 = new Cliente();
        final Cliente c3 = new Cliente();

        c1.codigo = 1;
        c1.nome = "Jose";
        c1.endereco = "Rua X,99";
        c1.saldo = 100;

        c2.codigo = 1;
        c2.nome = "Maria";
        c2.endereco = "Rua Y,123";
        c2.saldo = 200;

        c3.codigo = 1;
        c3.nome = "Fernanda";
        c3.endereco = "Rua Q,25";
        c3.saldo = 400;

        clientes = Arrays.asList(c1, c2, c3);

    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        return clientes;
    }

    @GetMapping("/clientes/{codigo}")
    public Cliente getClientes(@PathVariable int codigo) {
        Cliente cli=null;

        /*
        for(int i=0; i < clientes.size();i++){
            Cliente aux = clientes.get(i);
            if(aux.codigo == codigo){
                cli = aux;
                break;
            }
        }
        */

        for(Cliente aux: clientes){
            if(aux.codigo == codigo){
                cli = aux;
                break;
            }
        }

        return cli;
    }
}