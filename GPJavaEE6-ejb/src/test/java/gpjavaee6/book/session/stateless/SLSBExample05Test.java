package gpjavaee6.book.session.stateless;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class SLSBExample05Test {

    private static final Logger LOG = Logger.getLogger(SLSBExample05Test.class.getName());

    public SLSBExample05Test() {
    }

    @Test
    public void testExecute() throws Exception {
        LOG.info("Criando o container EJB embarcado.");
        EJBContainer container = EJBContainer.createEJBContainer();
        Context context = container.getContext();

        LOG.info("Criando a instância do SLSB 5.");
        LocalInterface01 myBean = (LocalInterface01) context
                .lookup("java:global/classes/SLSBExample05!gpjavaee6.book.session.stateless.LocalInterface01");

        LOG.info("Chamando o método de negócio.");
        System.out.println(myBean.sayHello("Jaumzera"));

        LOG.info("Encerrando o container.");
        container.close();
        LOG.info("Fim.");
        assertTrue(true);
    }
}
