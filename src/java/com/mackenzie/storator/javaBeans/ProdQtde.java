/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mackenzie.storator.javaBeans;

import java.io.Serializable;

/**
 *
 * @author 31300022
 */
public class ProdQtde implements Serializable{
    private Produto produto;
    private int quantidade;

    public ProdQtde(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
