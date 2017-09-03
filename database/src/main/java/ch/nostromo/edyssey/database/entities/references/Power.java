package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Power extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public Power() {
        super();
    }

    public Power(String name) {
        super(name);
    }

}
