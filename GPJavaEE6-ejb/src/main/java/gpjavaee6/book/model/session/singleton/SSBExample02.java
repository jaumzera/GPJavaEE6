package gpjavaee6.book.model.session.singleton;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@DependsOn("SSBExample01")
@Lock(LockType.READ)
public class SSBExample02 {

    private static final Logger LOG = Logger.getLogger(SSBExample02.class.getName());
    
    @EJB
    private SSBExample02 myInstance;
    
    
    @PostConstruct
    private void init() {
        LOG.info(SSBExample02.class.getSimpleName() + " init");
    }
    
    public void readA() {
        LOG.log(Level.INFO, "{0} running readA.", 
                SSBExample02.class.getSimpleName());
        readB();
        writeA();
    }
    
    public void readB() {
        LOG.log(Level.INFO, "{0} running readB.", 
                SSBExample02.class.getSimpleName());
        myInstance.readC();
        
    }
    
    private void readC() {
        LOG.log(Level.INFO, "{0} running readC.", 
                SSBExample02.class.getSimpleName());
    }
    
    public void illegalRead() {
        LOG.log(Level.INFO, "{0} running illegalRead.", 
                SSBExample02.class.getSimpleName());
        myInstance.writeA();
    }

    @Lock(LockType.WRITE)
    public void writeA() {
        try {
            LOG.log(Level.INFO, "{0} running writeA.",
                    SSBExample02.class.getSimpleName());
            Thread.sleep(3000);
            writeB();
            LOG.log(Level.INFO, "{0} leaving aBlockingWriteMethod.",
                    SSBExample02.class.getSimpleName());
        } catch (InterruptedException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
    
    @Lock(LockType.WRITE)
    public void writeB() {
        LOG.log(Level.INFO, "{0} running writeB.", 
                SSBExample02.class.getSimpleName());
    }
}
