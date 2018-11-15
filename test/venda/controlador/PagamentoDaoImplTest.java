/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package venda.controlador;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import venda.modelo.Cliente;
import venda.modelo.Pagamento;

/**
 *
 * @author josafams
 */
public class PagamentoDaoImplTest {
    
    private PagamentoDao instance = new PagamentoDaoImpl();
    private VendaDao vendaDao = new VendaDaoImpl();
    
    public PagamentoDaoImplTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testCriar() {
        System.out.println("criar");
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(BigDecimal.ZERO);
        pagamento.setVenda(vendaDao.todas().get(0));
        instance.criar(pagamento);
    }

    @Ignore
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        Pagamento pagamento = null;
        PagamentoDaoImpl instance = new PagamentoDaoImpl();
        instance.deletar(pagamento);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Pagamento pagamento = null;
        PagamentoDaoImpl instance = new PagamentoDaoImpl();
        instance.atualizar(pagamento);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Pagamento pagamento = null;
        PagamentoDaoImpl instance = new PagamentoDaoImpl();
        Pagamento expResult = null;
        Pagamento result = instance.buscar(pagamento);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testTodas() {
        System.out.println("todas");
        Cliente cliente = null;
        PagamentoDaoImpl instance = new PagamentoDaoImpl();
        ArrayList<Pagamento> expResult = null;
        ArrayList<Pagamento> result = instance.todas(cliente);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
