package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class CommodityBlackMarket extends ReferenceEntity implements Serializable{


    private static final long serialVersionUID = 1L;

    public CommodityBlackMarket() {
        super();
    }

    public CommodityBlackMarket(String name) {
        super(name);
    }

    
    
}
