package ch.nostromo.edyssey.journal;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.nostromo.edyssey.database.Database;
import ch.nostromo.edyssey.database.entities.Commander;
import ch.nostromo.edyssey.database.entities.StarSystem;
import ch.nostromo.edyssey.database.entities.StarSystemFaction;
import ch.nostromo.edyssey.database.entities.StarSystemFactionPendingState;
import ch.nostromo.edyssey.database.entities.StarSystemFactionRecoveringState;
import ch.nostromo.edyssey.database.entities.Station;
import ch.nostromo.edyssey.database.entities.journal.JournalDocked;
import ch.nostromo.edyssey.database.entities.journal.JournalFsdJump;
import ch.nostromo.edyssey.database.entities.references.PendingState;
import ch.nostromo.edyssey.database.entities.references.RecoveringState;
import ch.nostromo.edyssey.journal.json.Faction;
import ch.nostromo.edyssey.journal.json.FactionState;
import ch.nostromo.edyssey.journal.json.JournalEvent;
import ch.nostromo.edyssey.journal.json.JournalEventDocked;
import ch.nostromo.edyssey.journal.json.JournalEventFSDJump;

public class JournalDatabaseLoader {

	Database database;

	public JournalDatabaseLoader(Database database) {
		this.database = database;
	}

	public void loadFullDirectory(String commanderName, Path pathToScan)
			throws IOException, IllegalArgumentException, IllegalAccessException {

		database.getJournalEntityHelper().deleteCommander(commanderName);

		List<Path> files = Files.walk(pathToScan).filter(Files::isRegularFile).collect(Collectors.toList());

		for (Path path : files) {

			System.out.println("Reading file : " + path);

			List<String> jsons = Files.readAllLines(path, StandardCharsets.UTF_8);

			JsonFactory factory = new JsonFactory();
			ObjectMapper mapper = new ObjectMapper(factory);

			for (String json : jsons) {
				JournalEvent journalEntry = mapper.readerFor(JournalEvent.class).readValue(json);

				database.transactionStart();

				Commander commander = database.getJournalEntityHelper().getOrCreateCommander(commanderName);

				switch (journalEntry.getEvent()) {
				case "FSDJump": {
					handleFSDJump(commander, mapper.readerFor(JournalEventFSDJump.class).readValue(json));
					break;
				}
				case "Docked": {
					handleDocked(commander, mapper.readerFor(JournalEventDocked.class).readValue(json));
					break;
				}

				default: {

				}
				}

				database.transactionCommit();
				database.clearEntityManager();

			}
		}
	}

	private void handleDocked(Commander commander, JournalEventDocked event) {
		StarSystem starSystem = database.getMainEntityHelper().getStarSystem(event.getStarSystem());

		if (starSystem == null) {
			starSystem = database.getMainEntityHelper().getOrCreateStarSystem(event.getStarSystem());
		}
		
		Station stationToEdit = starSystem.getStationByName(event.getStationName());
		
		if (stationToEdit == null) {
		
		  stationToEdit = database.getMainEntityHelper().getOrCreateStationInStarSystem(starSystem, event.getStationName());

	        // Add staiton values
	        String stationFaction = event.getStationFaction();
	        if (stationFaction != null) {
	            stationToEdit.setStationFaction(database.getReferenceEntityHelper().getOrCreateFaction(stationFaction));
	        }

	        String stationAllegiance = event.getStationAllegiance();
	        if (stationAllegiance != null) {
	            stationToEdit.setStationAllegiance(database.getReferenceEntityHelper().getOrCreateAllegiance(stationAllegiance));
	        }

	        String stationEconomy = event.getStationEconomy();
	        if (stationEconomy != null) {
	            stationToEdit.setStationEconomy(database.getReferenceEntityHelper().getOrCreateEconomy(stationEconomy));
	        }

	        String factionState = event.getFactionState();
	        if (factionState != null) {
	            stationToEdit.setStationFactionState(database.getReferenceEntityHelper().getOrCreateFactionState(factionState));
	        }

	        String stationGovernment = event.getStationGovernment();
	        if (stationGovernment != null) {
	            stationToEdit.setStationGovernment(database.getReferenceEntityHelper().getOrCreateGovernment(stationGovernment));
	        }

	        String stationType = event.getStationType();
	        if (stationType != null) {
	            stationToEdit.setStationType(database.getReferenceEntityHelper().getOrCreateStationType(stationType));
	        }

	        Double distance = event.getDistFromStarLS();
	        if (distance != null) {
	            stationToEdit.setDistFromStarLS(distance);
	        }
	
		}

		// Create docked journal entry
		JournalDocked entry = database.getJournalEntityHelper().createJournalDockedEntity(commander);
		entry.setTimestamp(event.getTimestamp().getTime());
		entry.setStation(stationToEdit);
		
	}

	private void handleFSDJump(Commander commander, JournalEventFSDJump event) {

		StarSystem starSystem = database.getMainEntityHelper().getStarSystem(event.getStarSystem());

		// update star system
		if (starSystem == null) {

			starSystem = database.getMainEntityHelper().getOrCreateStarSystem(event.getStarSystem());

			String systemFactionState = event.getFactionState();
			if (systemFactionState != null) {
				starSystem.setFactionState(
						database.getReferenceEntityHelper().getOrCreateFactionState(systemFactionState));
			}

			String systemFaction = event.getSystemFaction();
			if (systemFaction != null) {
				starSystem.setSystemFaction(database.getReferenceEntityHelper().getOrCreateFaction(systemFaction));
			}

			String systemSecurity = event.getSystemSecurity();
			if (systemSecurity != null) {
				starSystem.setSystemSecurity(database.getReferenceEntityHelper().getOrCreateSecurity(systemSecurity));
			}

			String systemAllegiance = event.getSystemAllegiance();
			if (systemAllegiance != null) {
				starSystem.setSystemAllegiance(
						database.getReferenceEntityHelper().getOrCreateAllegiance(systemAllegiance));
			}

			String systemEconomy = event.getSystemEconomy();
			if (systemEconomy != null) {
				starSystem.setSystemEconomy(database.getReferenceEntityHelper().getOrCreateEconomy(systemEconomy));
			}

			String powerplayState = event.getPowerPlayState();
			if (powerplayState != null) {
				starSystem.setPowerPlayState(
						database.getReferenceEntityHelper().getOrCreatePowerPlayState(powerplayState));
			}

			String systemGovernment = event.getSystemGovernment();
			if (systemGovernment != null) {
				starSystem.setSystemGovernment(
						database.getReferenceEntityHelper().getOrCreateGovernment(systemGovernment));
			}

			// Readd all powers to the system ;)
			String[] powers = event.getPowers();
			if (powers != null) {
				starSystem.getPowers().clear();
				for (String power : powers) {
					starSystem.getPowers().add(database.getReferenceEntityHelper().getOrCreatePower(power));
				}
			}

			Faction[] factions = event.getFactions();
			if (factions != null) {
				addFactionsToStarsystem(starSystem, factions);
			}

		}

		// Create fsd journal entry
		JournalFsdJump entry = database.getJournalEntityHelper().createJournalFsdJumpEntity(commander);
		entry.setTimestamp(event.getTimestamp().getTime());
		entry.setStarSystem(starSystem);
	}

	private void addFactionsToStarsystem(StarSystem starSystem, Faction[] factions) {
		// Well, remove all ;)
		starSystem.getSystemFactions().clear();

		for (Faction faction : factions) {

			StarSystemFaction starSystemFaction = database.getMainEntityHelper()
					.createSystemFactionInStarSystem(starSystem);

			starSystemFaction.setFaction(database.getReferenceEntityHelper().getOrCreateFaction(faction.getName()));
			starSystemFaction
					.setAllegiance(database.getReferenceEntityHelper().getOrCreateAllegiance(faction.getAllegiance()));
			starSystemFaction
					.setGovernment(database.getReferenceEntityHelper().getOrCreateGovernment(faction.getGovernment()));
			starSystemFaction.setFactionState(
					database.getReferenceEntityHelper().getOrCreateFactionState(faction.getFactionState()));
			starSystemFaction.setInfluence(faction.getInfluence());

			if (faction.getPendingStates() != null) {
				FactionState[] pendingStates = faction.getPendingStates();

				for (FactionState factionState : pendingStates) {
					PendingState pendingState = database.getReferenceEntityHelper()
							.getOrCreatePendingState(factionState.getState());
					Integer trend = factionState.getTrend();

					StarSystemFactionPendingState starSystemFactionPendingState = database.getMainEntityHelper()
							.createPendingStateInFaction(starSystemFaction);

					starSystemFactionPendingState.setPendingState(pendingState);
					starSystemFactionPendingState.setTrend(trend);

				}
			}

			if (faction.getRecoveringStates() != null) {
				FactionState[] recoveringStates = faction.getRecoveringStates();

				for (FactionState factionState : recoveringStates) {
					RecoveringState recoveringState = database.getReferenceEntityHelper()
							.getOrCreateRecoveringState(factionState.getState());
					Integer trend = factionState.getTrend();

					StarSystemFactionRecoveringState starSystemFactionRecoveringState = database.getMainEntityHelper()
							.createRecoveringStateInFaction(starSystemFaction);

					starSystemFactionRecoveringState.setRecoveringState(recoveringState);
					starSystemFactionRecoveringState.setTrend(trend);
				}
			}

		}

	}

}
