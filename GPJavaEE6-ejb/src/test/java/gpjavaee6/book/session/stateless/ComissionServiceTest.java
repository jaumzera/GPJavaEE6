package gpjavaee6.book.session.stateless;

import gpjavaee6.book.model.Person;
import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComissionServiceTest {

    private static final Logger LOG = Logger.getLogger(ComissionServiceTest.class.getName());

    public ComissionServiceTest() {
    }

    @Test
    public void testExecute() throws Exception {
        LOG.info("Criando o container EJB embarcado.");
        EJBContainer container = EJBContainer.createEJBContainer();
        Context context = container.getContext();

        LOG.info("Criando a instância de " + ComissionService.class.getSimpleName());
        ComissionService instance = (ComissionService) 
                context.lookup("java:global/classes/ComissionService"
                        + "!gpjavaee6.book.session.stateless.ComissionService");
        System.out.println("Comissioned value: " 
                + instance.calculate(new BigDecimal("100")));
        
        LOG.info("Encerrando o container.");
        container.close();
        LOG.info("Fim.");
        assertTrue(true);
    }
}
