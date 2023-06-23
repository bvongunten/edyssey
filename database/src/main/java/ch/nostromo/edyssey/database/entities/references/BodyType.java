package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class BodyType extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public BodyType() {
        super();
    }

    public BodyType(String name) {
        super(name);
    }

}
