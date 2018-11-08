/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.controlador;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import venda.modelo.Cliente;
import venda.modelo.Endereco;

/**
 *
 * @author josafams
 */
public class ClienteDaoImplTest {
    
    private Cliente cliente;
    
    public ClienteDaoImplTest() {
    }
      
    @Before
    public void setUp() {
        cliente = new Cliente();
        cliente.setNome("nome");
        cliente.setPlanoDeFidelidade(true);
        cliente.setRg("rg");
        cliente.setEndereco(new Endereco());
        cliente.getEndereco().setRua("RUA");
        cliente.getEndereco().setBairro("BAIRRO");
        cliente.getEndereco().setEstado("CE");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of criar method, of class ClienteDaoImpl.
     */
    @Test
    public void testCriar() {
        System.out.println("criar");   
        ClienteDaoImpl instance = new ClienteDaoImpl();
        instance.criar(cliente);
    }

    /**
     * Test of deletar method, of class ClienteDaoImpl.
     */
    @Ignore
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        Cliente pessoa = null;
        ClienteDaoImpl instance = new ClienteDaoImpl();
        instance.deletar(pessoa);
       
    }

    /**
     * Test of atualizar method, of class ClienteDaoImpl.
     */
    @Ignore
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        cliente.setNome("novo nome");
        ClienteDaoImpl instance = new ClienteDaoImpl();
        instance.atualizar(cliente);
    }

    /**
     * Test of buscar method, of class ClienteDaoImpl.
     */
    @Ignore
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int codigo = 0;
        ClienteDaoImpl instance = new ClienteDaoImpl();
        Cliente expResult = null;
        Cliente result = instance.buscar(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of todas method, of class ClienteDaoImpl.
     */
    @Ignore
    @Test
    public void testTodas() {
        System.out.println("todas");
        ClienteDaoImpl instance = new ClienteDaoImpl();
        ArrayList<Cliente> expResult = null;
        ArrayList<Cliente> result = instance.todas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
