package gpjavaee6.book.session.stateless;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class SLSBExample03Test {

    private static final Logger LOG = Logger.getLogger(SLSBExample03Test.class.getName());
    
    public SLSBExample03Test() {
    }

    @Test
    public void testMyThirdBusinessMethod() throws Exception {
        LOG.info("Criando o container EJB embarcado.");
        EJBContainer container = EJBContainer.createEJBContainer();
        Context context = container.getContext();
      
        LOG.info("Criando a instância do SLSB 3.");
        SLSBExample03 sessionBean3 = (SLSBExample03) context.lookup("java:global/classes/SLSBExample03");

        LOG.info("Chamando o método de negócio.");
        sessionBean3.myThirdBusinessMethod();

        LOG.info("Encerrando o container.");
        container.close();
        LOG.info("Fim.");
        assertTrue(true);
    }
}
