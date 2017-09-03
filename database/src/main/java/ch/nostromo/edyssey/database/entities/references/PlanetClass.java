package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PlanetClass extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public PlanetClass() {
        super();
    }

    public PlanetClass(String name) {
        super(name);
    }

}
