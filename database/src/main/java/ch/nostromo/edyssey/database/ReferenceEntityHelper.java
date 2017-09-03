package ch.nostromo.edyssey.database;

import ch.nostromo.edyssey.database.entities.references.Allegiance;
import ch.nostromo.edyssey.database.entities.references.Atmosphere;
import ch.nostromo.edyssey.database.entities.references.AtmosphereComposition;
import ch.nostromo.edyssey.database.entities.references.BodyType;
import ch.nostromo.edyssey.database.entities.references.Commodity;
import ch.nostromo.edyssey.database.entities.references.CommodityBlackMarket;
import ch.nostromo.edyssey.database.entities.references.CommodityBracket;
import ch.nostromo.edyssey.database.entities.references.Economy;
import ch.nostromo.edyssey.database.entities.references.Faction;
import ch.nostromo.edyssey.database.entities.references.FactionState;
import ch.nostromo.edyssey.database.entities.references.Government;
import ch.nostromo.edyssey.database.entities.references.Material;
import ch.nostromo.edyssey.database.entities.references.Module;
import ch.nostromo.edyssey.database.entities.references.PendingState;
import ch.nostromo.edyssey.database.entities.references.PlanetClass;
import ch.nostromo.edyssey.database.entities.references.Power;
import ch.nostromo.edyssey.database.entities.references.PowerPlayState;
import ch.nostromo.edyssey.database.entities.references.RecoveringState;
import ch.nostromo.edyssey.database.entities.references.ReferenceEntity;
import ch.nostromo.edyssey.database.entities.references.RingClass;
import ch.nostromo.edyssey.database.entities.references.Security;
import ch.nostromo.edyssey.database.entities.references.Ship;
import ch.nostromo.edyssey.database.entities.references.StarType;
import ch.nostromo.edyssey.database.entities.references.StationType;
import ch.nostromo.edyssey.database.entities.references.TerraformState;
import ch.nostromo.edyssey.database.entities.references.Volcanism;

public class ReferenceEntityHelper {

	Database database;

	public ReferenceEntityHelper(Database database) {
		this.database = database;
	}

	private ReferenceEntity getOrCreateEntity(Class<? extends ReferenceEntity> entityClass, String name) {
		if (name == null || name.isEmpty()) {
			return null;
		}

		ReferenceEntity result = database.getEntityManager().find(entityClass, name);
		if (result == null) {
			try {
				result = entityClass.newInstance();
				result.setId(name);
				database.persistEntity(result);
			} catch (InstantiationException | IllegalAccessException e) {
				throw new DatabaseException(e);
			}
		}

		return result;
	}

	
	public Government getOrCreateGovernment(String name) {
		if (name == null || name.isEmpty()) {
			return null;
		}

		name = name.replace("$government_", "");
		name = name.replace(";", "");

		return (Government) getOrCreateEntity(Government.class, name);
	}

	public Allegiance getOrCreateAllegiance(String name) {
		return (Allegiance) getOrCreateEntity(Allegiance.class, name);
	}

	public Faction getOrCreateFaction(String name) {
		return (Faction) getOrCreateEntity(Faction.class, name);

	}

	public FactionState getOrCreateFactionState(String name) {
		return (FactionState) getOrCreateEntity(FactionState.class, name);
	}

	public Economy getOrCreateEconomy(String name) {
		return (Economy) getOrCreateEntity(Economy.class, name);
	}

	public PendingState getOrCreatePendingState(String name) {
		return (PendingState) getOrCreateEntity(PendingState.class, name);
	}

	public RecoveringState getOrCreateRecoveringState(String name) {
		return (RecoveringState) getOrCreateEntity(RecoveringState.class, name);
	}

	public Security getOrCreateSecurity(String name) {
		return (Security) getOrCreateEntity(Security.class, name);
	}

	public Power getOrCreatePower(String name) {
		return (Power) getOrCreateEntity(Power.class, name);
	}

	public PowerPlayState getOrCreatePowerPlayState(String name) {
		return (PowerPlayState) getOrCreateEntity(PowerPlayState.class, name);
	}

	public BodyType getOrCreateBodyType(String name) {
		return (BodyType) getOrCreateEntity(BodyType.class, name);
	}

	public Commodity getOrCreateCommodity(String name) {
		return (Commodity) getOrCreateEntity(Commodity.class, name);
	}

	public CommodityBlackMarket getOrCreateCommodityBlackMarket(String name) {
		return (CommodityBlackMarket) getOrCreateEntity(CommodityBlackMarket.class, name);
	}

	public StationType getOrCreateStationType(String name) {
		return (StationType) getOrCreateEntity(StationType.class, name);
	}

	public StarType getOrCreateStarType(String name) {
		return (StarType) getOrCreateEntity(StarType.class, name);
	}

	public RingClass getOrCreateRingClass(String name) {
		return (RingClass) getOrCreateEntity(RingClass.class, name);
	}

	public TerraformState getOrCreateTerraformState(String name) {
		return (TerraformState) getOrCreateEntity(TerraformState.class, name);
	}

	public Volcanism getOrCreateVolacnism(String name) {
		return (Volcanism) getOrCreateEntity(Volcanism.class, name);
	}

	public PlanetClass getOrCreatePlanetClass(String name) {
		return (PlanetClass) getOrCreateEntity(PlanetClass.class, name);
	}

	public Material getOrCreateMaterial(String name) {
		return (Material) getOrCreateEntity(Material.class, name);
	}

	public Atmosphere getOrCreateAtmosphere(String name) {
		return (Atmosphere) getOrCreateEntity(Atmosphere.class, name);
	}

	public AtmosphereComposition getOrCreateAtmosphereComposition(String name) {
		return (AtmosphereComposition) getOrCreateEntity(AtmosphereComposition.class, name);
	}

	public CommodityBracket getOrCreateCommodityBracket(String name) {
		return (CommodityBracket) getOrCreateEntity(CommodityBracket.class, name);
	}

	public Module getOrCreateModule(String name) {
		return (Module) getOrCreateEntity(Module.class, name);
	}

	public Ship getOrCreateShip(String name) {
		return (Ship) getOrCreateEntity(Ship.class, name);
	}

}
