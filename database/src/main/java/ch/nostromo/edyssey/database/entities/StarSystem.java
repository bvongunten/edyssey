package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ch.nostromo.edyssey.database.entities.references.Allegiance;
import ch.nostromo.edyssey.database.entities.references.Economy;
import ch.nostromo.edyssey.database.entities.references.Faction;
import ch.nostromo.edyssey.database.entities.references.FactionState;
import ch.nostromo.edyssey.database.entities.references.Government;
import ch.nostromo.edyssey.database.entities.references.Power;
import ch.nostromo.edyssey.database.entities.references.PowerPlayState;
import ch.nostromo.edyssey.database.entities.references.Security;

@Entity
public class StarSystem extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column
    String id;

    @Column
    String description;

    @Column
    private Double starPosX;

    @Column
    private Double starPosY;

    @Column
    private Double starPosZ;

    @ManyToOne
    private FactionState factionState;

    @ManyToOne
    private Faction systemFaction;

    @ManyToOne
    private Security systemSecurity;

    @ManyToOne
    private Government systemGovernment;

    @ManyToOne
    private Allegiance systemAllegiance;

    @ManyToOne
    private Economy systemEconomy;

    @ManyToOne
    private PowerPlayState powerPlayState;

    @OneToMany(mappedBy="starSystem")
    private List<Station> stations = new ArrayList<>();

    @OneToMany(mappedBy="starSystem")
    private List<Body> bodies = new ArrayList<>();

    @OneToMany(mappedBy="starSystem")
    private List<StarSystemFaction> starSystemFactions = new ArrayList<>();

    @ManyToMany()
    private List<Power> powers = new ArrayList<>();

    public StarSystem() {
        super();
    }


	/**** HELPER *****/
    
    public Station getStationByName(String name) {
        for (Station station : stations) {
            if (station.getStationName().equalsIgnoreCase(name)) {
                return station;
            }
        }
        return null;

    }
    
    public boolean containsStationName(String name) {
        for (Station station : stations) {
            if (station.getStationName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean containsBodyName(String name) {
        for (Body body : bodies) {
            if (body.getBodyName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    
    public Body getBodyByName(String name) {
        for (Body body : bodies) {
            if (body.getBodyName().equalsIgnoreCase(name)) {
                return body;
            }
        }
        return null;
    }
    
    /**** GETTERS / SETTERS *****/
    
    public Faction getSystemFaction() {
        return systemFaction;
    }

    public void setSystemFaction(Faction systemFaction) {
        this.systemFaction = systemFaction;
    }

    public Double getStarPosX() {
        return starPosX;
    }

    public void setStarPosX(Double starPosX) {
        this.starPosX = starPosX;
    }

    public Double getStarPosY() {
        return starPosY;
    }

    public void setStarPosY(Double starPosY) {
        this.starPosY = starPosY;
    }

    public Double getStarPosZ() {
        return starPosZ;
    }

    public void setStarPosZ(Double starPosZ) {
        this.starPosZ = starPosZ;
    }

    public void setName(String name) {
        this.id = name;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Station> getStations() {
        return stations;
    }

    public FactionState getFactionState() {
        return factionState;
    }

    public void setFactionState(FactionState factionState) {
        this.factionState = factionState;
    }

    public Security getSystemSecurity() {
        return systemSecurity;
    }

    public void setSystemSecurity(Security systemSecurity) {
        this.systemSecurity = systemSecurity;
    }

    public Allegiance getSystemAllegiance() {
        return systemAllegiance;
    }

    public void setSystemAllegiance(Allegiance systemAllegiance) {
        this.systemAllegiance = systemAllegiance;
    }

    public Economy getSystemEconomy() {
        return systemEconomy;
    }

    public void setSystemEconomy(Economy systemEconomy) {
        this.systemEconomy = systemEconomy;
    }

    public List<StarSystemFaction> getSystemFactions() {
        return starSystemFactions;
    }

    public void setSystemFactions(List<StarSystemFaction> starSystemFactions) {
        this.starSystemFactions = starSystemFactions;
    }

    public PowerPlayState getPowerPlayState() {
        return powerPlayState;
    }

    public void setPowerPlayState(PowerPlayState powerPlayState) {
        this.powerPlayState = powerPlayState;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public void setPowers(List<Power> powers) {
        this.powers = powers;
    }

    public Government getSystemGovernment() {
        return systemGovernment;
    }

    public void setSystemGovernment(Government systemGovernment) {
        this.systemGovernment = systemGovernment;
    }

    public List<Body> getBodies() {
        return bodies;
    }

    public void setBodies(List<Body> bodies) {
        this.bodies = bodies;
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

	public List<StarSystemFaction> getStarSystemFactions() {
		return starSystemFactions;
	}

	public void setStarSystemFactions(List<StarSystemFaction> starSystemFactions) {
		this.starSystemFactions = starSystemFactions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}    
    

}
