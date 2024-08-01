package com.biblioteca.gerenciamento.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class EmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmprestimo;
    @OneToOne
    private UsuarioModel usuario;
    @OneToOne
    private LivroModel livro;
    private Date emprestimo;
    private Date devolucao;
    private double multa;

    public long getIdEmprestimo() {
        return idEmprestimo;
    }
    public void setIdEmprestimo(long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
    public UsuarioModel getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
    public LivroModel getLivro() {
        return livro;
    }
    public void setLivro(LivroModel livro) {
        this.livro = livro;
    }
    public Date getEmprestimo() {
        return emprestimo;
    }
    public void setEmprestimo(Date emprestimo) {
        this.emprestimo = emprestimo;
    }
    public Date getDevolucao() {
        return devolucao;
    }
    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }
    public double getMulta() {
        return multa;
    }
    public void setMulta(double multa) {
        this.multa = multa;
    }
    
    
}
