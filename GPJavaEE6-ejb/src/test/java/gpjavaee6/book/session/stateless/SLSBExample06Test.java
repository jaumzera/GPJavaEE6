package gpjavaee6.book.session.stateless;

import gpjavaee6.book.model.Person;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.Test;
import static org.junit.Assert.*;

public class SLSBExample06Test {

    private static final Logger LOG = Logger.getLogger(SLSBExample06Test.class.getName());

    public SLSBExample06Test() {
    }

    @Test
    public void testExecute() throws Exception {
        LOG.info("Criando o container EJB embarcado.");
        EJBContainer container = EJBContainer.createEJBContainer();
        Context context = container.getContext();

        LOG.info("Criando a instância do SLSB 6.");
        SLSBExample06Local local = (SLSBExample06Local) context
                .lookup("java:global/classes/SLSBExample06!gpjavaee6.book.session.stateless.SLSBExample06Local");
        SLSBExample06Remote remote = (SLSBExample06Remote) context
                .lookup("java:global/classes/SLSBExample06!gpjavaee6.book.session.stateless.SLSBExample06Remote");

        LOG.info("Chamando o método de negócio.");
        Person person = new Person("joão massan");
        local.captalize(person);
        System.out.println("Name has been changed by local bean: " 
                + person.getName());
        
        Person another = new Person("jack daniels");
        remote.sayHello(another);
        System.out.println("Name has not been changed by remote bean: " 
                + another.getName());

        LOG.info("Encerrando o container.");
        container.close();
        LOG.info("Fim.");
        assertTrue(true);
    }
}
