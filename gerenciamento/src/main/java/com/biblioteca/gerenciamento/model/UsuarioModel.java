package com.biblioteca.gerenciamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class UsuarioModel {
    
    @Id
    @NotNull
    private long cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private boolean autorizado;



    public long getCpf() {
        return cpf;
    }
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isAutorizado() {
        return autorizado;
    }
    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }
}
