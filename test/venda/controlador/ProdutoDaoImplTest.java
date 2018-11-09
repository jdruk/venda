package venda.controlador;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import venda.modelo.Produto;

public class ProdutoDaoImplTest {

    private Produto produto = null;
    private ProdutoDao instance;

    public ProdutoDaoImplTest() {
    }

    @Before
    public void setUp() {
        instance = new ProdutoDaoImpl();
        produto = new Produto();
        produto.setNome("produto");
        produto.setValor(new BigDecimal("1222.01"));
    }

    @Test
    public void testCriar() {
        System.out.println("criar produto");
        instance = new ProdutoDaoImpl();
        instance.criar(produto);
    }

    @Test
    public void testBuscar() {
        System.out.println("buscar produto");
        Integer codigo = null;
        ProdutoDaoImpl instance = new ProdutoDaoImpl();
        Produto expResult = null;
        Produto result = instance.buscar(31);
        assertNotNull(result);
        assertEquals(new Integer(31), result.getCodigo());
    }

    @Test
    public void testAtualizar() {
        System.out.println("atualizar produto");
        instance = new ProdutoDaoImpl();
        Produto p = instance.buscar(31);
        p.setNome("alterado");
        instance.atualizar(p);
    }

    @Test
    public void testDeletar() {
        System.out.println("deletar produto");
        Produto p = new Produto();
        p.setCodigo(30);
        ProdutoDao instance = new ProdutoDaoImpl();
        instance.deletar(p);
    }

    @Test
    public void testTodos() {
        System.out.println("todos produtos");
        ProdutoDaoImpl instance = new ProdutoDaoImpl();
        List<Produto> expResult = null;
        List<Produto> result = instance.todos();
        assertFalse( result.isEmpty());
    }

}
