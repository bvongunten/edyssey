package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class RecoveringState extends ReferenceEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    public RecoveringState() {
        super();
    }

    public RecoveringState(String name) {
        super(name);
    }


}
