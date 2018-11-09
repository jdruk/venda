package venda.controlador;

<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import venda.modelo.Cliente;
import venda.modelo.Endereco;

public class EnderecoDaoImplTest {

    private Endereco endereco;
    private Cliente cliente;

    public EnderecoDaoImplTest() {
    }

    @Before
    public void setUp() {
        endereco = new Endereco();
        cliente = new ClienteDaoImpl().buscar(2);
        cliente.setEndereco(endereco);
    }

    /**
     * Test of criar method, of class EnderecoDaoImpl.
     */
    @Test
    public void testCriar() {
        endereco = new Endereco();
        endereco.setRua("RUA");
        endereco.setBairro("BAIRRO");
        endereco.setEstado("ES");
        System.out.println("criar endereco");
        endereco.setCliente(cliente);
        EnderecoDao instance = new EnderecoDaoImpl();
        instance.criar(endereco);
    }

    /**
     * Test of deletar method, of class EnderecoDaoImpl.
     */
    @Test
    public void testDeletar() {
       System.out.println("Deletar endereco");
       EnderecoDao instance = new EnderecoDaoImpl();
       endereco = new Endereco();
       endereco.setCodigo(4);
       instance.deletar(endereco);
    }

    /**
     * Test of atualizar method, of class EnderecoDaoImpl.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        EnderecoDao instance = new EnderecoDaoImpl();
        endereco = new Endereco();
        endereco.setCodigo(5);
        endereco.setBairro("novo bairro");
        instance.atualizar(endereco);
    }

    /**
     * Test of buscar method, of class EnderecoDaoImpl.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar endereco");
        Cliente cliente = new Cliente();
        cliente.setCodigo(1);
        EnderecoDao instance = new EnderecoDaoImpl();
        Endereco expResult = null;
        Endereco result = instance.buscar(cliente);
        assertNotNull("", result);
    }

=======
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import venda.modelo.Cliente;
import venda.modelo.Endereco;

public class EnderecoDaoImplTest {
    
    private Endereco endereco;
    
    public EnderecoDaoImplTest() {
    }
    
    @Before
    public void setUp() {
        endereco = new Endereco();
        endereco.setRua("RUA");
        endereco.setBairro("BAIRRO");
        endereco.setEstado("ES");
    }
    

    /**
     * Test of criar method, of class EnderecoDaoImpl.
     */
    @Test
    public void testCriar() {
        System.out.println("criar");
        EnderecoDaoImpl instance = new EnderecoDaoImpl();
        instance.criar(endereco);
    }

    /**
     * Test of deletar method, of class EnderecoDaoImpl.
     */
    @Ignore
    @Test
    public void testDeletar() {
        System.out.println("deletar");
        EnderecoDaoImpl instance = new EnderecoDaoImpl();
        instance.deletar(endereco);
    }

    /**
     * Test of atualizar method, of class EnderecoDaoImpl.
     */
    @Ignore
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        Endereco endereco = null;
        EnderecoDaoImpl instance = new EnderecoDaoImpl();
        instance.atualizar(endereco);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class EnderecoDaoImpl.
     */
    @Ignore
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        Cliente cliente = null;
        EnderecoDaoImpl instance = new EnderecoDaoImpl();
        Endereco expResult = null;
        Endereco result = instance.buscar(cliente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
>>>>>>> origin/master
}
