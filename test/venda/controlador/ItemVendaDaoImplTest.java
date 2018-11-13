package venda.controlador;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import venda.modelo.ItemVenda;

public class ItemVendaDaoImplTest {
    
    public ItemVendaDaoImplTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testCriar() {
        System.out.println("criar");
        ItemVenda itemVenda = null;
        ItemVendaDaoImpl instance = new ItemVendaDaoImpl();
        instance.criar(itemVenda);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeletar() {
        System.out.println("deletar");
        ItemVenda itemVenda = null;
        ItemVendaDaoImpl instance = new ItemVendaDaoImpl();
        instance.deletar(itemVenda);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        ItemVenda itemVenda = null;
        ItemVendaDaoImpl instance = new ItemVendaDaoImpl();
        instance.atualizar(itemVenda);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int codigo = 0;
        ItemVendaDaoImpl instance = new ItemVendaDaoImpl();
        ItemVenda expResult = null;
        ItemVenda result = instance.buscar(codigo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTodos() {
        System.out.println("todos");
        ItemVendaDaoImpl instance = new ItemVendaDaoImpl();
        List<ItemVenda> expResult = null;
        List<ItemVenda> result = instance.todos();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
