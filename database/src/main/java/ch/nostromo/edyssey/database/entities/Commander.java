package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ch.nostromo.edyssey.database.entities.journal.JournalEvent;

@Entity
public class Commander extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column
    String id;

    @OneToMany(mappedBy="commander")
    private List<JournalEvent> journalEvents = new ArrayList<>();
    
    public Commander() {
        super();
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<JournalEvent> getJournalEvents() {
		return journalEvents;
	}

	public void setJournalEvents(List<JournalEvent> journalEvents) {
		this.journalEvents = journalEvents;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    

}
