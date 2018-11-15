import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import venda.controlador.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ClienteDaoImplTest.class, ProdutoDaoImplTest.class,
    EnderecoDaoImplTest.class, EstoqueDaoImplTest.class, VendaDaoImplTest.class, 
    ItemVendaDaoImplTest.class})

public class SuiteTestes {

    
}
