/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mackenzie.storator.dao;

import com.mackenzie.storator.exception.PersistenciaException;
import java.util.List;


/**
 *
 * @author Rafael
 */
public interface GenericDAO<E> {
    
    void inserir(E e) throws PersistenciaException;
    
    void atualizar(E e) throws PersistenciaException;
    
    void excluir(Integer id) throws PersistenciaException;
    
    List<E> listar() throws PersistenciaException;
    
    E buscarPorId(Integer id) throws PersistenciaException;
    
}
