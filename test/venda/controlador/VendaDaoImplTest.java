package venda.controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import venda.modelo.Cliente;
import venda.modelo.Venda;

public class VendaDaoImplTest {
    
    private Venda venda;
    private VendaDaoImpl instance;
    private ClienteDao clienteDao;
    private ProdutoDao produtoDao;
    
    public VendaDaoImplTest() {
    }
    
    @Before
    public void setUp() {
        venda = new Venda();
        clienteDao = new ClienteDaoImpl();
        instance = new VendaDaoImpl();
        produtoDao = new ProdutoDaoImpl();
    }

    @Test
    public void testCriar() {
        System.out.println("criar venda");
        Cliente cliente = clienteDao.todos().get(0);
        assertNotNull(cliente);
        venda.setCliente(cliente);
        venda.setData(new Date());
        venda.setStatus(Venda.Status.ABERTO.toInt());
        venda.setTipo(0);
        venda.setPagamento(new ArrayList<>());
        venda.setItensVenda(new ArrayList<>());
        instance.criar(venda);
    }

    @Test
    public void testDeletar() {
        System.out.println("deletar venda");
        instance.deletar(instance.todas().get(0));
    }
    
    @Test
    public void testAtualizar() {
        System.out.println("atualizar venda");
        venda.setTipo(1);
        assertFalse(clienteDao.todos().isEmpty());
        Cliente cliente = clienteDao.todos().get(0);
        venda.setCliente(cliente);
        instance.atualizar(venda);
    }

    @Test
    public void testBuscar() {
        System.out.println("buscar venda");
        venda = instance.buscar(8);
        assertNotNull(venda);
    }
    
    @Test
    public void testTodas() {
        System.out.println("todas vendas");
        List<Venda> vendas = instance.todas();
        assertFalse(vendas.isEmpty());
    }
    
}
