package ch.nostromo.edyssey.database;

import ch.nostromo.edyssey.database.entities.Body;
import ch.nostromo.edyssey.database.entities.BodyAtmosphereComposition;
import ch.nostromo.edyssey.database.entities.BodyMaterial;
import ch.nostromo.edyssey.database.entities.BodyRing;
import ch.nostromo.edyssey.database.entities.StarSystem;
import ch.nostromo.edyssey.database.entities.StarSystemFaction;
import ch.nostromo.edyssey.database.entities.StarSystemFactionPendingState;
import ch.nostromo.edyssey.database.entities.StarSystemFactionRecoveringState;
import ch.nostromo.edyssey.database.entities.Station;
import ch.nostromo.edyssey.database.entities.StationCommodity;
import ch.nostromo.edyssey.database.entities.StationCommodityBlackMarket;

public class MainEntityHelper {

	Database database;

	public MainEntityHelper(Database database) {
		this.database = database;
	}


	public StarSystem getStarSystem(String name) {
		return database.getEntityManager().find(StarSystem.class, name);
	}
	
	public StarSystem getOrCreateStarSystem(String name) {
		StarSystem result = getStarSystem(name);
		if (result == null) {
			result = new StarSystem();
			result.setId(name);
			database.persistEntity(result);
		}
		return result;
	}


	public Body getOrCreateBodyInStarSystem(StarSystem starSystem, String bodyName) {
		Body result = starSystem.getBodyByName(bodyName);

		if (result == null) {
			result = new Body(starSystem, bodyName);
			database.persistEntity(result);

			// Add to starsystem & station
			starSystem.getBodies().add(result);
		}

		return result;
	}


	public Station getOrCreateStationInStarSystem(StarSystem starSystem, String stationName) {
		Station result = starSystem.getStationByName(stationName);

		if (result == null) {
			result = new Station(starSystem, stationName);
			database.persistEntity(result);

			// Add to starsystem
			starSystem.getStations().add(result);
		}

		return result;
	}

	public StarSystemFaction createSystemFactionInStarSystem(StarSystem starSystem) {
		StarSystemFaction result = new StarSystemFaction(starSystem);
		database.persistEntity(result);

		starSystem.getSystemFactions().add(result);
		return result;
	}

	public StarSystemFactionPendingState createPendingStateInFaction(StarSystemFaction faction) {
		StarSystemFactionPendingState result = new StarSystemFactionPendingState(faction);
		database.persistEntity(result);

		faction.getPendingStates().add(result);
		return result;
	}

	public StarSystemFactionRecoveringState createRecoveringStateInFaction(StarSystemFaction faction) {
		StarSystemFactionRecoveringState result = new StarSystemFactionRecoveringState(faction);
		database.persistEntity(result);

		faction.getRecoveringStates().add(result);
		return result;
	}

	public BodyRing createBodyRingOnBody(Body body) {
		BodyRing result = new BodyRing(body);
		database.persistEntity(result);

		body.getRings().add(result);
		return result;
	}

	public BodyMaterial createBodyMaterialOnBody(Body body) {
		BodyMaterial result = new BodyMaterial(body);
		database.persistEntity(result);

		body.getMaterial().add(result);
		return result;
	}

	public StationCommodity createStationCommodityOnStation(Station station) {
		StationCommodity result = new StationCommodity(station);
		database.persistEntity(result);

		station.getStationCommodities().add(result);
		return result;
	}

	public StationCommodityBlackMarket createStationCommodityBlackMarketOnStation(Station station) {
		StationCommodityBlackMarket result = new StationCommodityBlackMarket(station);
		database.persistEntity(result);

		station.getStationCommoditiesBlackMarket().add(result);
		return result;
	}

	public BodyAtmosphereComposition createBodyAtmosphereCompositionOnBody(Body body) {
		BodyAtmosphereComposition result = new BodyAtmosphereComposition(body);
		database.persistEntity(result);

		body.getAtmosphereComposition().add(result);
		return result;
	}
	
}
