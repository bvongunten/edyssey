package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PowerPlayState extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public PowerPlayState() {
        super();
    }

    public PowerPlayState(String name) {
        super(name);
    }

}
