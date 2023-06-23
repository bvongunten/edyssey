package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Volcanism extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public Volcanism() {
        super();
    }

    public Volcanism(String name) {
        super(name);
    }

}
