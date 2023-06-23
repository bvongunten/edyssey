package ch.nostromo.edyssey.database.entities.journal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.nostromo.edyssey.database.entities.BaseEntity;
import ch.nostromo.edyssey.database.entities.Commander;

@Entity
public class JournalEvent extends BaseEntity implements Serializable{


    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
 
    @Column
    private Date timestamp;
    
    @ManyToOne
    private Commander commander;
    
    public JournalEvent() {
        // Default
    }
    
    public JournalEvent(Commander commander) {
    	this.commander = commander;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Commander getCommander() {
		return commander;
	}

	public void setCommander(Commander commander) {
		this.commander = commander;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


}
