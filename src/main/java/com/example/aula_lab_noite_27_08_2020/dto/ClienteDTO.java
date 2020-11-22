package com.example.aula_lab_noite_27_08_2020.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class ClienteDTO {

    @NotBlank(message = "Nome é obrigatório!")
    @Length(min=4, max=40, message = "Nome deve ter minimo de 4 e maximo de 40 caracteres!")
    private String nome;


    @NotBlank(message = "Endereço é obrigatório!")
    @Length(min=4, max=40, message = "Endereço deve ter minimo de 4 e maximo de 40 caracteres!")
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
}
