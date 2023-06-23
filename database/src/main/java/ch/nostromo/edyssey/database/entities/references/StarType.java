package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class StarType extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public StarType() {
        super();
    }

    public StarType(String name) {
        super(name);
    }

}
