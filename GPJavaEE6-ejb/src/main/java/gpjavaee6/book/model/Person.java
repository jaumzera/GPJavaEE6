package gpjavaee6.book.model;

import java.io.Serializable;

/**
 *
 * @author jaumzera
 */
public class Person implements Serializable {
    
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
