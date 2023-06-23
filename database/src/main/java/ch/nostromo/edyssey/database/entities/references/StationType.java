package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class StationType extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public StationType() {
        super();
    }

    public StationType(String name) {
        super(name);
    }

}
