/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.controlador;

import java.util.List;
import venda.modelo.Funcionario;

/**
 *
 * @author josafams
 */
public interface FuncionarioDao {
    void criar(Funcionario funcionario);
    void deletar(Funcionario funcionario);
    void atualizar(Funcionario funcionario);
    Funcionario buscar(int codigo);
    List<Funcionario> todos();
}
