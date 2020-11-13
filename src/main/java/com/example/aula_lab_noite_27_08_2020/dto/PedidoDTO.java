package com.example.aula_lab_noite_27_08_2020.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.example.aula_lab_noite_27_08_2020.model.ItemPedido;

public class PedidoDTO {
    private long numero;
    private String descricao;
    private LocalDateTime dataPedido;
    private boolean pedidoFechado;
    private ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();
    private double totalPedido;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }
    
    public boolean isPedidoFechado() {
        return pedidoFechado;
    }

    public void setPedidoFechado(boolean pedidoFechado) {
        this.pedidoFechado = pedidoFechado;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

}
