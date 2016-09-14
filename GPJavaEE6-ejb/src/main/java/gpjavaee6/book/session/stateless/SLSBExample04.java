package gpjavaee6.book.session.stateless;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SLSBExample04 {

    private static final Logger LOG = 
            Logger.getLogger(SLSBExample04.class.getName());
    
    @EJB
    private SLSBExample03 slsb03; 
    
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "[{0}] @PostConstruct executando", 
                SLSBExample04.class.getName());
    }
    
    public void myFourthBusinessMethod() {
        LOG.log(Level.INFO, "{0}: método de negócio executando", 
                SLSBExample04.class.getSimpleName());
        slsb03.myThirdBusinessMethod();
    }
    
    @PreDestroy
    public void end() {
        LOG.log(Level.INFO, "[{0}] Prestes a ser destruido", 
                SLSBExample04.class.getName());
    }
}
