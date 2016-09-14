package gpjavaee6.book.session.stateless;

import java.math.BigDecimal;
import javax.ejb.Remote;

@Remote
public interface ComissionServiceRemote {
    
    BigDecimal calculate(BigDecimal value);
    
}
