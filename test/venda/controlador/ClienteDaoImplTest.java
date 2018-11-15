package venda.controlador;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import venda.modelo.Cliente;
import venda.modelo.Endereco;

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
        System.out.println("criar cliente");
        ClienteDaoImpl instance = new ClienteDaoImpl();
        instance.criar(cliente);
    }

    /**
     * Test of deletar method, of class ClienteDaoImpl.
     */
    @Ignore
    @Test
    public void testDeletar() {
        System.out.println("deletar cliente");
        Cliente cliente = new Cliente();
        cliente.setCodigo(0);
        ClienteDao instance = new ClienteDaoImpl();
        instance.deletar(cliente);

    }

    /**
     * Test of atualizar method, of class ClienteDaoImpl.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar cliente");
        cliente.setCodigo(1);
        cliente.setNome("novo nome");
        ClienteDao instance = new ClienteDaoImpl();
        instance.atualizar(cliente);
    }

    /**
     * Test of buscar method, of class ClienteDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar cliente");
        int codigo = 1;
        ClienteDao instance = new ClienteDaoImpl();
        Cliente result = instance.buscar(codigo);
        assertEquals("novo nome", result.getNome());
        assertEquals("rua", result.getEndereco().getRua());
    }

    /**
     * Test of todas method, of class ClienteDaoImpl.
     */
    @Test
    public void testTodas() {
        System.out.println("todos clientes");
        ClienteDao instance = new ClienteDaoImpl();
        ArrayList<Cliente> result = instance.todas();
        assertFalse("Dever ter itens na lista", result.isEmpty());
    }

}
