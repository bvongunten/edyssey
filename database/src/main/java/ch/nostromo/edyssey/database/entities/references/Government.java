package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Government extends ReferenceEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    public Government() {
        super();
    }

    public Government(String name) {
        super(name);
    }


}
