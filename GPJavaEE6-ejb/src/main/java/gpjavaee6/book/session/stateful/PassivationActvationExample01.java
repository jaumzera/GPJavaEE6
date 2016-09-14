package gpjavaee6.book.session.stateful;

import gpjavaee6.book.model.Seller;
import gpjavaee6.book.session.stateless.ComissionService;
import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@Stateful
public class PassivationActvationExample01 {

    private static final Logger LOG = Logger.getLogger(PassivationActvationExample01.class.getName());
    
    private Seller seller;
    
    private BigDecimal comission;
    
    @EJB
    private ComissionService comissionService;
    
    private Integer idCache;
    
    private String nameCache;

    @PostConstruct 
    public void init() {
        LOG.info("Init " + PassivationActvationExample01.class.getSimpleName());
    }
    
    public void configureUser(Integer id, String name, BigDecimal value) {
        seller = new Seller();
        seller.setId(id);
        seller.setName(name);
        comission = comissionService.calculate(value);
        seller.setComission(comission);
    }
    
    public Seller getSeller() {
        return seller;
    }
    
    @PrePassivate
    public void saveSellerData() {
        LOG.info("Saving seller data before passivation.");
        idCache = seller.getId();
        nameCache = seller.getName();
        seller = null;
    }
    
    @PostActivate
    public void restoreSellerData() {
        LOG.info("Restoring seller data after activation.");
        seller = new Seller();
        seller.setId(idCache);
        seller.setName(nameCache);
        seller.setComission(comission);
    }
}
