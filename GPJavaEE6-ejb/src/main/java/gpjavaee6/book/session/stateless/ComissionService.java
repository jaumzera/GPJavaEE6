package gpjavaee6.book.session.stateless;

import java.math.BigDecimal;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ComissionService implements ComissionServiceRemote {
    
    public BigDecimal calculate(BigDecimal value) {
        return value.multiply(new BigDecimal("1.15"));
    }
}
