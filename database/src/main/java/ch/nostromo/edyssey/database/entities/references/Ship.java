package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Ship extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public Ship() {
        super();
    }

    public Ship(String name) {
        super(name);
    }

}
