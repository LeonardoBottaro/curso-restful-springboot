package com.example.aula_lab_noite_27_08_2020.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @GetMapping("/cliente")
    public String getClientes(){
        return "Vai algum dia retornar do BD TODOS os clientes!";
    }

    @GetMapping("/cliente/{codigo}")
    public String getCliente1(@PathVariable int codigo){
        if (codigo > 0)
            return "Vai algum dia retornar um cliente" + codigo;
        else
            return "Erro, codigo negativo" + codigo;
    }
}