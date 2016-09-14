package gpjavaee6.book.session.stateless;

import gpjavaee6.book.model.Person;
import javax.ejb.Local;

@Local
public interface SLSBExample06Local {
    
    void captalize(Person person);
    
}
