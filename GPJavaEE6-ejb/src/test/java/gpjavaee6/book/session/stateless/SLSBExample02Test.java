package gpjavaee6.book.session.stateless;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class SLSBExample02Test {

    private static final Logger LOG = Logger.getLogger(SLSBExample02Test.class.getName());
    
    public SLSBExample02Test() {
    }

    @Test
    public void testMySecondBusinessMethod() throws Exception {
        LOG.info("Criando o container EJB embarcado.");
        EJBContainer container = EJBContainer.createEJBContainer();
        Context context = container.getContext();
      
        LOG.info("Criando a instância do SLSB 2.");
        SLSBExample02 sessionBean2 = (SLSBExample02) context.lookup("java:global/classes/SLSBExample02");

        LOG.info("Chamando o método de negócio.");
        sessionBean2.mySecondBusinessMethod();

        LOG.info("Encerrando o container.");
        container.close();
        LOG.info("Fim.");
        assertTrue(true);
    }
}
