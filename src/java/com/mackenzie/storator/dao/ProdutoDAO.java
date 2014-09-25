/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mackenzie.storator.dao;

import com.mackenzie.storator.exception.PersistenciaException;
import com.mackenzie.storator.javaBeans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael
 */
public class ProdutoDAO implements GenericDAO<Produto>{

    @Override
    public void inserir(Produto produto) throws PersistenciaException {
        
        Connection connection = Conexao.getInstance().getConnection();
        String sql = "INSERT INTO VALUES ()";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível salvar os dados no bd");
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void atualizar(Produto e) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Integer id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> listar() throws PersistenciaException {
        
        ArrayList<Produto> list = new ArrayList<Produto>();
        Connection connection = Conexao.getInstance().getConnection();
        String sql = "SELECT FROM ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = null; // = new Produto() ;   ARRUMAR QUANDO DB ESTIVER PRONTO
                list.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível salvar os dados no bd");
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;    
    }

    @Override
    public Produto buscarPorId(Integer id) throws PersistenciaException {
        
        Produto produto = null;
        Connection connection = Conexao.getInstance().getConnection();
        String sql = "SELECT FROM WHERE "+id;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //produto = new Produto();     ARRUMAR QUANDO DB ESTIVER PRONTO
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenciaException("Não foi possível salvar os dados no bd");
        } finally {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produto;
    }
    
}
