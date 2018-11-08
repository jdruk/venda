/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.controlador;

import java.util.ArrayList;
import venda.modelo.Cliente;

/**
 *
 * @author josafams
 */
interface ClienteDao {
    
    void criar(Cliente cliente);
    void deletar(Cliente cliente);
    void atualizar(Cliente cliente);
    Cliente buscar(int cliente);
    public ArrayList<Cliente> todas();
}
