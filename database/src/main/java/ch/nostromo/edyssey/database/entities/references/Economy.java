package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Economy extends ReferenceEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    public Economy() {
        super();
    }

    public Economy(String name) {
        super(name);
    }


}
