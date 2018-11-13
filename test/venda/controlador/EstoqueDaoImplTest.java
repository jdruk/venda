package venda.controlador;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import venda.modelo.Estoque;

public class EstoqueDaoImplTest {
    
    private EstoqueDao instance;
    private Estoque estoque;

    public EstoqueDaoImplTest() {
    }
    
    @Before
    public void setUp() {
        estoque = new Estoque();
        estoque.setProduto(new ProdutoDaoImpl().buscar(8));        
        estoque.setQuantidade(10);
        instance = new EstoqueDaoImpl();
    }
    
    @Test
    public void testCriar() {
        System.out.println("criar estoque");
        assertNotNull(estoque.getProduto());
        instance.criar(estoque);
    }
    
    @Test
    public void testDeletar() {
        System.out.println("deletar estoque");
        Estoque estoqueParaExclusao = new Estoque();
        estoqueParaExclusao.setCodigo(0);
        instance.deletar(estoque);
    }
    
    @Test
    public void testAtualizar() {
        System.out.println("atualizar estoque");
        estoque.setCodigo(1);
        estoque.setQuantidade(1000);
        instance.atualizar(estoque);
        
    }
    
    @Test
    public void testBuscar() {
        System.out.println("buscar estoque");
        estoque = instance.buscar(3);
        assertNotNull(estoque);
    }
    
    @Test
    public void testTodos() {
       System.out.println("todos estoque");
       assertFalse(instance.todos().isEmpty());
    }
    
}
