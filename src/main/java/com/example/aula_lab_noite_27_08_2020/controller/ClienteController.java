package com.example.aula_lab_noite_27_08_2020.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.aula_lab_noite_27_08_2020.dto.ClienteDTO;
import com.example.aula_lab_noite_27_08_2020.model.Cliente;
import com.example.aula_lab_noite_27_08_2020.repository.ClienteRepository;
import com.example.aula_lab_noite_27_08_2020.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteService service;

    @GetMapping()
    public List<Cliente> getClientes() {
        return repository.getAllClientes();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getClientes(@PathVariable int codigo) {
        Cliente cliente = repository.getClienteByCodigo(codigo);

        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody ClienteDTO clienteDTO, HttpServletRequest request, UriComponentsBuilder builder){
        Cliente cliente = service.fromDTO(clienteDTO);

        cliente = repository.save(cliente);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + cliente.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build(); 
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        Cliente cliente = repository.getClienteByCodigo(codigo);

        if(cliente != null){
            repository.remove(cliente);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int codigo, @RequestBody ClienteDTO clienteDTO){
        if(repository.getClienteByCodigo(codigo) != null){
            Cliente cliente = service.fromDTO(clienteDTO);
            cliente.setCodigo(codigo);
            cliente = repository.update(cliente);
            return ResponseEntity.ok(cliente);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}