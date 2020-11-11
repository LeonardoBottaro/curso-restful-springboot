package com.example.aula_lab_noite_27_08_2020.service;

import java.util.List;
import java.util.Optional;

import com.example.aula_lab_noite_27_08_2020.dto.ClienteDTO;
import com.example.aula_lab_noite_27_08_2020.model.Cliente;
import com.example.aula_lab_noite_27_08_2020.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repositorio;
    
    public Cliente fromDTO(ClienteDTO dto){
        
        Cliente cliente = new Cliente();
        cliente.setEndereco(dto.getEndereco());
        cliente.setNome(dto.getNome());
        return cliente;
    }

	public List<Cliente> getAllClientes() {
		return repositorio.getAllClientes();
	}

	public Cliente getClienteByCodigo(int codigo) {
        Optional<Cliente> op = repositorio.getClienteByCodigo(codigo);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Cliente nao cadastrado"));
	}

	public Cliente save(Cliente cliente) {
		return repositorio.save(cliente);
	}

	public void removeByCodigo(int codigo) {
        repositorio.remove(getClienteByCodigo(codigo));

	}

	public Cliente update(Cliente cliente) {
        getClienteByCodigo(cliente.getCodigo());
        return repositorio.update(cliente);
	}
}
