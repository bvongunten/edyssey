package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PendingState extends ReferenceEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    public PendingState() {
        super();
    }

    public PendingState(String name) {
        super(name);
    }


}
