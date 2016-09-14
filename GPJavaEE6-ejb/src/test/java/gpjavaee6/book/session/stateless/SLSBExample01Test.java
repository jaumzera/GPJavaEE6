package gpjavaee6.book.session.stateless;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;

public class SLSBExample01Test {

    private static final Logger LOG = Logger.getLogger(SLSBExample01Test.class.getName());

    public SLSBExample01Test() {
    }

    @Test
    public void testFirstSessionBean() throws NamingException {
        LOG.info("Criando o container EJB embarcado.");
        EJBContainer container = EJBContainer.createEJBContainer();
        Context context = container.getContext();

        LOG.info("Criando a instância do SLSB.");
        SLSBExample01 sessionBean1 = (SLSBExample01) context.lookup("java:global/classes/SLSBExample01");

        LOG.info("Chamando o método de negócio.");
        sessionBean1.myFirstBusinessMethod();

        LOG.info("Encerrando o container.");
        container.close();
        LOG.info("Fim.");
        assertTrue(true);
    }
}
