package gpjavaee6.book.session.stateless;

import gpjavaee6.book.model.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

@Stateless
public class SLSBExample06 implements SLSBExample06Local, SLSBExample06Remote {

    private static final Logger LOG
            = Logger.getLogger(SLSBExample06.class.getName());

    @PostConstruct
    public void init() {
        LOG.log(Level.INFO, "[{0}] @PostConstruct executando",
                SLSBExample06.class.getSimpleName());
    }

    @PreDestroy
    public void end() {
        LOG.log(Level.INFO, "[{0}] Prestes a ser destruido",
                SLSBExample06.class.getSimpleName());
    }

    private String toCapitalized(String toCapitalize) {
        StringBuilder capitalized = new StringBuilder();
        for (String parts : toCapitalize.split("\\s+")) {
            capitalized.append(parts.substring(0, 1).toUpperCase());
            capitalized.append(parts.substring(1));
            capitalized.append(" ");
        }
        return capitalized.toString().replace("\\s$", "");
    }

    @Override
    public void captalize(Person person) {
        person.setName(toCapitalized(person.getName()));
        System.out.println("Capitalized " + person.getName());
    }

    @Override
    public void sayHello(Person to) {
        to.setName(toCapitalized(to.getName()));
        System.out.println("Hello to " + to.getName());
    }

}
