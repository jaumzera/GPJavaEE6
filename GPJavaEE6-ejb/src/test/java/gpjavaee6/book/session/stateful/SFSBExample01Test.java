package gpjavaee6.book.session.stateful;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;

public class SFSBExample01Test {

    private static final Logger LOG = Logger.getLogger(SFSBExample01Test.class.getName());

    @Test
    public void testFirstSessionBean() throws NamingException {
        EJBContainer container = EJBContainer.createEJBContainer();
        Context context = container.getContext();
        SFSBExample01 bean = (SFSBExample01) context.lookup("java:global/classes/SFSBExample01");
        LOG.info("Chamando o método de negócio.");
        bean.sayHello("World");
        bean.sayHello("Mariah");
        bean.sayHello("Everybody");
        bean.sayGoodBye();
        bean.sayHello("Jaumzera");
        container.close();
        assertTrue(true);
    }
}
