package com.example.aula_lab_noite_27_08_2020.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.aula_lab_noite_27_08_2020.model.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {

    private List <Cliente> clientes;

    @PostConstruct
    public void criarClientes(){
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        c1.setCodigo(1);
        c1.setNome("Jose");
        c1.setEndereco("Rua X,99");
        c1.setSaldo(100);

        c2.setCodigo(2);
        c2.setNome("Maria");
        c2.setEndereco("Rua Y,123");
        c2.setSaldo(200);

        c3.setCodigo(3);
        c3.setNome("Fernanda");
        c3.setEndereco("Rua Q,25");
        c3.setSaldo(400);

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
    }

    public List<Cliente> getAllClientes(){
        return clientes;
    }

    public Cliente getClienteByCodigo(int codigo){
        for(Cliente aux: clientes){
            if(aux.getCodigo() == codigo){
                return aux;
            }
        }
        return null;
    }

    public Cliente save(Cliente cliente){

        cliente.setCodigo(clientes.size() + 1);
        clientes.add(cliente);
        return cliente;

    }
}
