package com.mackenzie.storator.model;


import com.mackenzie.storator.javaBeans.ProdQtde;
import com.mackenzie.storator.javaBeans.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 31300022
 */
public class Carrinho {
    
    private final List<Produto> listaProd;
    private final List<Integer> listaQtde;

    public Carrinho() {
        listaProd = new ArrayList<>();
        listaQtde = new ArrayList<>();
    }

    public boolean addProduto(Produto produto) {
        if (listaProd.contains(produto)) {
            int pos = listaProd.indexOf(produto);
            listaQtde.set(pos, listaQtde.get(pos)+1);
        } else {
            listaProd.add(produto);
            listaQtde.add(1);
        }
        return true;
    }

    public boolean removeProduto(Produto produto) {
         if (listaProd.contains(produto)) {
            int pos = listaProd.indexOf(produto);
            int quant = listaQtde.get(pos);
            if (quant != 1)
                listaQtde.set(pos, quant--);
            else {
                listaProd.remove(pos);
                listaQtde.remove(pos);
            }
            return true;
        } 
         else {
             System.out.println("Produto não pode ser removido pois não existe");
             return false;
         }
    }

    public List<ProdQtde> listaProduto() {
        List<ProdQtde> lista;
        lista = new ArrayList<>();
        for(int i = 0; i<listaProd.size(); i++){
            lista.add(new ProdQtde(listaProd.get(i), listaQtde.get(i)));
        }
        return lista;
    }  
}
