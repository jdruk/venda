package venda.controlador;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import venda.modelo.ItemVenda;

public class ItemVendaDaoImplTest {
    
    private VendaDao vendaDao;
    private ProdutoDao produtoDao;
    private ItemVendaDaoImpl instance;
    
    public ItemVendaDaoImplTest() {
    }
    
    @Before
    public void setUp() {
        instance = new ItemVendaDaoImpl();
        produtoDao = new ProdutoDaoImpl();
        vendaDao = new VendaDaoImpl();
    }

    @Test
    public void testCriar() {
        System.out.println("criar item venda");
        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setProduto(produtoDao.todos().get(0));
        itemVenda.setVenda(vendaDao.todas().get(0));
        itemVenda.setQuantidade(10);
        itemVenda.setValorVenda(itemVenda.getProduto().getValor());
        ItemVendaDaoImpl instance = new ItemVendaDaoImpl();
        instance.criar(itemVenda);
    }

    @Test
    public void testDeletar() {
        System.out.println("deletar item venda");
        List<ItemVenda> itens = instance.todos(vendaDao.todas().get(0));
        instance.deletar(itens.get(itens.size() - 1));
    }

    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        ItemVenda item = instance.buscar(2);
        item.setProduto(produtoDao.todos().get(produtoDao.todos().size() -1 ));
        instance.atualizar(item);
    }
    
    @Test
    public void testBuscar() {
        System.out.println("buscar item venda");
        assertNotNull(instance.buscar(2));
    }

    @Test
    public void testTodos() {
        System.out.println("todos item vendas");
        assertFalse(instance.todos(vendaDao.buscar(6)).isEmpty());
    }
    
}
