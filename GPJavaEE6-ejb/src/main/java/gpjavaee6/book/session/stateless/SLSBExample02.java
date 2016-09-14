package gpjavaee6.book.session.stateless;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@Stateless
public class SLSBExample02 {

    private static final Logger LOG = Logger.getLogger(SLSBExample02.class.getName());
    
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "[{0}] @PostConstruct executando", SLSBExample02.class.getSimpleName());
    }
    
    public void mySecondBusinessMethod() {
        LOG.info("Método de negócio #2 executando");
        try {
            InitialContext context = new InitialContext();
            SLSBExample01 slsb1 = (SLSBExample01) context.lookup("java:global/classes/SLSBExample01");
            slsb1.myFirstBusinessMethod();
        } catch (NamingException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }
    
    @PreDestroy
    public void end() {
        LOG.log(Level.INFO, "[{0}] Prestes a ser destruido", SLSBExample02.class.getSimpleName());
    }
}
