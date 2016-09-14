package gpjavaee6.book.session.stateful;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PreDestroy;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class SFSBExample01 {
    
    private Integer invocationCount = 0;
    
    private Set<String> visitors = new HashSet<String>();
    
    public void sayHello(String to) {
        System.out.println(String.format("Hello from %s (called %d times) to %s.",
                SFSBExample01.class.getSimpleName(), ++invocationCount, to));
        visitors.add(to);
    }
    
    @Remove
    public void sayGoodBye() {
        for(String to : visitors) {
            System.out.println("Goodbye " + to);
        }
    }
    
    @PreDestroy
    public void end() {
        System.out.println(String.format("%s is about to die.",
                SFSBExample01.class.getSimpleName()));
    }
}
