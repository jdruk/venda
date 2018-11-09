package venda.controlador;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import venda.modelo.Venda;

public class VendaDaoImplTest {
    
    public VendaDaoImplTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testCriar() {
        System.out.println("criar");
        Venda venda = null;
        VendaDaoImpl instance = new VendaDaoImpl();
        instance.criar(venda);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeletar() {
        System.out.println("deletar");
        Venda venda = null;
        VendaDaoImpl instance = new VendaDaoImpl();
        instance.deletar(venda);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Venda venda = null;
        VendaDaoImpl instance = new VendaDaoImpl();
        instance.atualizar(venda);
        fail("The test case is a prototype.");
    }

    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int codigo = 0;
        VendaDaoImpl instance = new VendaDaoImpl();
        Venda expResult = null;
        Venda result = instance.buscar(codigo);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testTodas() {
        System.out.println("todas");
        VendaDaoImpl instance = new VendaDaoImpl();
        ArrayList<Venda> expResult = null;
        ArrayList<Venda> result = instance.todas();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
