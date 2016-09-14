package gpjavaee6.book.session.stateful;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaumzera
 */
public class PassivationActvationExample01Test {

    @Test
    public void test() throws NamingException, InterruptedException {
        EJBContainer container = EJBContainer.createEJBContainer();
        Context context = container.getContext();

        List<PassivationActvationExample01> beans = new ArrayList<PassivationActvationExample01>();
        for (int i = 0; i < 1000; i++) {
            System.out.println("Bean count " + (i + 1));
            PassivationActvationExample01 bean = (PassivationActvationExample01) 
                    context.lookup("java:global/classes/PassivationActvationExample01");
            bean.configureUser(i, "Jaumzera " + i, new BigDecimal("150.00"));
            beans.add(bean);
            Thread.sleep(10);
        }
        
        for(PassivationActvationExample01 bean : beans) {
            System.out.println(bean.getSeller());
        }
        
        container.close();
        assertTrue(true);
    }
}
