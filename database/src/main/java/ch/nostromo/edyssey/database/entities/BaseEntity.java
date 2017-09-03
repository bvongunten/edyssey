package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;


    @Column
    private Date created;

    @Column
    private Date updated;

    @Column
    private int updateCount = 0;
    

    @PrePersist
    public void prepersist() {
        this.created = new Date();
    }
    
    @PreUpdate
    public void preupdate() {
        this.updated = new Date();
        this.updateCount ++;
    }


    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public int getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }
    
    
    
}
