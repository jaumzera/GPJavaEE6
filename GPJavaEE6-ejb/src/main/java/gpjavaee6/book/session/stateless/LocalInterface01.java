package gpjavaee6.book.session.stateless;

import javax.ejb.Local;

@Local
public interface LocalInterface01 {
    
    String sayHello(String to);
    
}
