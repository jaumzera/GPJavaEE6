package gpjavaee6.book.model;

import java.math.BigDecimal;

public class Seller {

    private Integer id;

    private String name;

    private BigDecimal comission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getComission() {
        return comission;
    }

    public void setComission(BigDecimal comission) {
        this.comission = comission;
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, comission: %.2f",
                id, name, comission.doubleValue());
    }
}
