package gpjavaee6.book.session.stateless;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class SLSBExample01 {

    private static final Logger LOG = Logger.getLogger(SLSBExample01.class.getName());
    
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "[{0}] @PostConstruct executando", SLSBExample01.class.getName());
    }
    
    public void myFirstBusinessMethod() {
        LOG.info("Método de negócio executando");
    }
    
    @PreDestroy
    public void end() {
        LOG.log(Level.INFO, "[{0}] Prestes a ser destruido", SLSBExample01.class.getName());
    }
}
