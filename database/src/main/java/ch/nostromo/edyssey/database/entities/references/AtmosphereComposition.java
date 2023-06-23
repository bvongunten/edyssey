package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class AtmosphereComposition extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public AtmosphereComposition() {
        super();
    }

    public AtmosphereComposition(String name) {
        super(name);
    }

}
