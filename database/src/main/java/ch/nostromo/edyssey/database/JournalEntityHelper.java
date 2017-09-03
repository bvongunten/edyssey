package ch.nostromo.edyssey.database;

import ch.nostromo.edyssey.database.entities.Commander;
import ch.nostromo.edyssey.database.entities.journal.JournalDocked;
import ch.nostromo.edyssey.database.entities.journal.JournalFsdJump;

public class JournalEntityHelper {

	Database database;

	public JournalEntityHelper(Database database) {
		this.database = database;
	}

	public void deleteCommander(String commander) {
		Commander existingCommander = database.getEntityManager().find(Commander.class, commander);

		if (existingCommander != null) {
			database.transactionStart();
			database.getEntityManager().remove(existingCommander);
			database.transactionCommit();
		}


	}

	public Commander getOrCreateCommander(String name) {
		Commander result = database.getEntityManager().find(Commander.class, name);
		if (result == null) {
			result = new Commander();
			result.setId(name);
			database.persistEntity(result);
		}
		return result;

	}

	public JournalFsdJump createJournalFsdJumpEntity(Commander commander) {
		JournalFsdJump result = new JournalFsdJump(commander);
		database.persistEntity(result);
		
		commander.getJournalEvents().add(result);
		return result;
	}

	public JournalDocked createJournalDockedEntity(Commander commander) {
		JournalDocked result = new JournalDocked(commander);
		database.persistEntity(result);
		
		commander.getJournalEvents().add(result);
		return result;
	}
	
}
