package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Atmosphere extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public Atmosphere() {
        super();
    }

    public Atmosphere(String name) {
        super(name);
    }

}
