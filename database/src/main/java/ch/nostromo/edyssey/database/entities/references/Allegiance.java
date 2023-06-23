package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Allegiance extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public Allegiance() {
        super();
    }

    public Allegiance(String name) {
        super(name);
    }

}
