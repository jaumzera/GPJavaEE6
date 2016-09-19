package gpjavaee6.book.model.session.singleton;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SSBExample03 {

    private static final Logger LOG = Logger.getLogger(SSBExample03.class.getName());
    
    @PostConstruct
    private void init() {
        LOG.info(SSBExample03.class.getSimpleName() + " init");
    }
    
    public synchronized void blockFor(long millis) {
        //  Código sincronizado aqui
    }
}
