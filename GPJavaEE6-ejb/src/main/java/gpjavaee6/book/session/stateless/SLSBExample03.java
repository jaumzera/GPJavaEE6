package gpjavaee6.book.session.stateless;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class SLSBExample03 {

    private static final Logger LOG = Logger.getLogger(SLSBExample03.class.getName());
    
    @Resource
    private SessionContext sessionContext;
    
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "[{0}] @PostConstruct executando", SLSBExample03.class.getName());
    }
    
    public void myThirdBusinessMethod() {
        LOG.log(Level.INFO, "{0}: método de negócio executando", SLSBExample03.class.getSimpleName());
        SLSBExample01 slsb1 = (SLSBExample01) sessionContext.lookup("java:global/classes/SLSBExample01");
        SLSBExample02 slsb2 = (SLSBExample02) sessionContext.lookup("java:global/classes/SLSBExample02");
        slsb1.myFirstBusinessMethod();
        slsb2.mySecondBusinessMethod();
    }
    
    @PreDestroy
    public void end() {
        LOG.log(Level.INFO, "[{0}] Prestes a ser destruido", SLSBExample03.class.getName());
    }
}
