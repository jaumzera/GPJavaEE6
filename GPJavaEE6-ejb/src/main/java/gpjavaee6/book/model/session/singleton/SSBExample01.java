package gpjavaee6.book.model.session.singleton;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class SSBExample01 {

    private static final Logger LOG = Logger.getLogger(SSBExample01.class.getName());
    
    @PostConstruct
    private void init() {
        LOG.info(SSBExample01.class.getSimpleName() + " init");
    }
    
    public void blockFor(long millis) {
        LOG.info(Thread.currentThread().getName() + " is running.");
        try {
            LOG.info(Thread.currentThread().getName() + " started at " 
                    + System.currentTimeMillis() 
                    + " and is going to block for " + millis + "ms");
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        LOG.info(Thread.currentThread().getName() + " is done.");
    }
}
