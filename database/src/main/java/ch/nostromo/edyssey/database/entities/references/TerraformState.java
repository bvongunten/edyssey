package ch.nostromo.edyssey.database.entities.references;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class TerraformState extends ReferenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public TerraformState() {
        super();
    }

    public TerraformState(String name) {
        super(name);
    }

}
