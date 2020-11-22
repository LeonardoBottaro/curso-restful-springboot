package com.example.aula_lab_noite_27_08_2020.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.example.aula_lab_noite_27_08_2020.dto.ClienteDTO;
import com.example.aula_lab_noite_27_08_2020.dto.PedidoDTO;
import com.example.aula_lab_noite_27_08_2020.model.Cliente;
import com.example.aula_lab_noite_27_08_2020.model.Pedido;
import com.example.aula_lab_noite_27_08_2020.service.ClienteService;
import com.example.aula_lab_noite_27_08_2020.service.PedidoService;

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
    private ClienteService clienteService;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping()
    public List<Cliente> getClientes() {
        return clienteService.getAllClientes();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Cliente> getClientes(@PathVariable int codigo) {
        Cliente cliente = clienteService.getClienteByCodigo(codigo);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<Void> salvar(@Valid @RequestBody ClienteDTO clienteDTO, HttpServletRequest request, UriComponentsBuilder builder){
        Cliente cliente = clienteService.fromDTO(clienteDTO);

        cliente = clienteService.save(cliente);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + cliente.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build(); 
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        clienteService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Cliente> atualizar(@PathVariable int codigo, @RequestBody ClienteDTO clienteDTO){
        
        Cliente cliente = clienteService.fromDTO(clienteDTO);
        cliente.setCodigo(codigo);
        cliente = clienteService.update(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping("{id}/pedidos")
    public ResponseEntity<Void> salvar(@PathVariable int id, @RequestBody Pedido pedido, HttpServletRequest request, UriComponentsBuilder builder){
        pedido = pedidoService.salvar(pedido, id);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + pedido.getNumero()).build();
        return ResponseEntity.created(uriComponents.toUri()).build(); 
    }

    @GetMapping("{id}/pedidos")
    public List<PedidoDTO> getPedidosCliente(@PathVariable int id){

        Cliente cliente = clienteService.getClienteByCodigo(id);
        return pedidoService.toListDTO(cliente.getPedidos());
    }
}