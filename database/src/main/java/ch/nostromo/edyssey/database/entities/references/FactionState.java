package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class FactionState extends ReferenceEntity implements Serializable{

    private static final long serialVersionUID = 1L;


    public FactionState() {
        super();
    }

    public FactionState(String name) {
        super(name);
    }
}
