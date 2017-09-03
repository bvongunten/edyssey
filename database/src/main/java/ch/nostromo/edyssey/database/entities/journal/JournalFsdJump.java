package ch.nostromo.edyssey.database.entities.journal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ch.nostromo.edyssey.database.entities.Commander;
import ch.nostromo.edyssey.database.entities.StarSystem;

@Entity
public class JournalFsdJump extends JournalEvent {


	private static final long serialVersionUID = 1L;

    @ManyToOne
	private StarSystem starSystem;

	public JournalFsdJump() {
		super();
	}

	public JournalFsdJump(Commander commander) {
		super(commander);
	}

	public StarSystem getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(StarSystem starSystem) {
		this.starSystem = starSystem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
}
