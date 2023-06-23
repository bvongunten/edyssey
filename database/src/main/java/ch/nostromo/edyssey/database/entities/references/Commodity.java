package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Commodity extends ReferenceEntity implements Serializable{


    private static final long serialVersionUID = 1L;

    public Commodity() {
        super();
    }

    public Commodity(String name) {
        super(name);
    }

    
    
}
