package com.example.aula_lab_noite_27_08_2020.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.aula_lab_noite_27_08_2020.model.Pedido;

import org.springframework.stereotype.Component;

@Component
public class PedidoRepository {
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    private static int nextNumero=1;
    
    public List<Pedido> getAllPedidos(){
        return pedidos;
    }

    public Optional<Pedido> getPedidoByNumero(long numero){
        for (Pedido aux : pedidos){
            if(aux.getNumero() == numero){
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Pedido save(Pedido pedido){
        pedido.setNumero(nextNumero++);
        pedidos.add(pedido);
        return pedido;
    }

    
}
