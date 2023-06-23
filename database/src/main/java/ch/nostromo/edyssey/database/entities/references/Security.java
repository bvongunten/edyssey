package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Security extends ReferenceEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    public Security() {
        super();
    }

    public Security(String name) {
        super(name);
    }


}
