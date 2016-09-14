package gpjavaee6.book.session.stateless;

import gpjavaee6.book.model.Person;
import javax.ejb.Remote;

@Remote
public interface SLSBExample06Remote {
    
    void sayHello(Person to);
    
}
