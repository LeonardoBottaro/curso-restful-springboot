package com.example.aula_lab_noite_27_08_2020.service;

import com.example.aula_lab_noite_27_08_2020.dto.ClienteDTO;
import com.example.aula_lab_noite_27_08_2020.model.Cliente;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    public Cliente fromDTO(ClienteDTO dto){
        
        Cliente cliente = new Cliente();
        cliente.setEndereco(dto.getEndereco());
        cliente.setNome(dto.getNome());

        return cliente;
    }
}
