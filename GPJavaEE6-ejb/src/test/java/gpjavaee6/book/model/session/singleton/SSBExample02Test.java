package gpjavaee6.book.model.session.singleton;

import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SSBExample02Test {

    private static final Logger LOG = Logger.getLogger(SSBExample02Test.class.getName());
    
    @Test
    public void test() throws NamingException {
          EJBContainer container = EJBContainer.createEJBContainer();
        final Context context = container.getContext();
        
        SSBExample02 singleton = (SSBExample02) 
                context.lookup("java:global/classes/SSBExample02");
        try {
            singleton.readA();
            singleton.readB();
            singleton.writeA();
            singleton.writeB();
            singleton.illegalRead();
        } catch(Exception ex) {
            LOG.info(ex.getMessage());
        }
      
        container.close();
        assertTrue(true);
    }
    
}
