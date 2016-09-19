package gpjavaee6.book.model.session.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaumzera
 */
public class SSBExample01Test {

    private static final Logger LOG = Logger.getLogger(SSBExample01Test.class.getName());

    @Test
    public void test() throws InterruptedException {
        EJBContainer container = EJBContainer.createEJBContainer();
        final Context context = container.getContext();
        
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    LOG.info(Thread.currentThread().getName() + " begins.");
                    SSBExample01 singleton = (SSBExample01) context
                            .lookup("java:global/classes/SSBExample01");
                    singleton.blockFor((long) (Math.random() * 3000));
                    LOG.info(Thread.currentThread().getName() + " ends.");
                } catch (NamingException ex) {
                    LOG.log(Level.SEVERE, null, ex);
                }
            }
        };
        
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++) {
            executor.execute(task);
        }
        executor.awaitTermination(10, TimeUnit.SECONDS);
        container.close();
        assertTrue(true);
    }
    
}
