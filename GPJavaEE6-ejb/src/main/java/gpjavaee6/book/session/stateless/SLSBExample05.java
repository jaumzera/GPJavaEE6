package gpjavaee6.book.session.stateless;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class SLSBExample05 implements LocalInterface01 {

    private static final Logger LOG = 
            Logger.getLogger(SLSBExample05.class.getName());
    
    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "[{0}] @PostConstruct executando", 
                SLSBExample05.class.getSimpleName());
    }
    
    public String execute() {
        LOG.log(Level.INFO, "{0}: método de negócio executando", 
                SLSBExample05.class.getSimpleName());
        return SLSBExample05.class.getSimpleName();
    }
    
    @Override
    public String sayHello(String to) {
        return String.format("Greetings from %s to %s", execute(), to);
    }
    
    @PreDestroy
    public void end() {
        LOG.log(Level.INFO, "[{0}] Prestes a ser destruido", 
                SLSBExample05.class.getSimpleName());
    }

   
}
