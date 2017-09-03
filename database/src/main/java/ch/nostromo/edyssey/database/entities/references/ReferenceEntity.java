package ch.nostromo.edyssey.database.entities.references;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import ch.nostromo.edyssey.database.entities.BaseEntity;

@MappedSuperclass
public class ReferenceEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column
    String id;

    @Column
    String description;

    public ReferenceEntity() {

    }

    public ReferenceEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public String toString() {
        return "ID= " + id;
    }
    
    
}
