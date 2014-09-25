package com.mackenzie.storator.javaBeans;

import java.io.Serializable;

/**
 *
 * @author 31300022
 */
public class Produto implements Serializable{
    
    private String nome;
    private String cod;
    private double preco;
    private String img;
    private String descricao;

    public Produto(String nome, String cod, double preco, String tipo, String descricao) {
        this.nome = nome;
        this.cod = cod;
        this.preco = preco;
        this.img = tipo;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
