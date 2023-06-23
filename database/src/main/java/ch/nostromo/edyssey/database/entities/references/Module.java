package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Module extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public Module() {
        super();
    }

    public Module(String name) {
        super(name);
    }

}
