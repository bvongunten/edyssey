package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class CommodityBracket extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public CommodityBracket() {
        super();
    }

    public CommodityBracket(String name) {
        super(name);
    }

}
