package gpjavaee6.book.session.stateless;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class SLSBExample04Test {

    private static final Logger LOG = Logger.getLogger(SLSBExample04Test.class.getName());

    public SLSBExample04Test() {
    }

    @Test
    public void testMyThirdBusinessMethod() throws Exception {
        LOG.info("Criando o container EJB embarcado.");
        EJBContainer container = EJBContainer.createEJBContainer();
        Context context = container.getContext();

        LOG.info("Criando a instância do SLSB 4.");
        SLSBExample04 sessionBean4 = (SLSBExample04) context.lookup("java:global/classes/SLSBExample04");

        LOG.info("Chamando o método de negócio.");
        sessionBean4.myFourthBusinessMethod();

        LOG.info("Encerrando o container.");
        container.close();
        LOG.info("Fim.");
        assertTrue(true);
    }
}
