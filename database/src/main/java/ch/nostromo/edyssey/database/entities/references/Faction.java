package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Faction extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public Faction() {
        super();
    }

    public Faction(String name) {
        super(name);
    }

}
