package ch.nostromo.edyssey.database.entities.journal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ch.nostromo.edyssey.database.entities.Commander;
import ch.nostromo.edyssey.database.entities.Station;

@Entity
public class JournalDocked extends JournalEvent {


	private static final long serialVersionUID = 1L;

    @ManyToOne
	private Station station;

	public JournalDocked() {
		super();
	}

	public JournalDocked(Commander commander) {
		super(commander);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}
	

	
	
}
