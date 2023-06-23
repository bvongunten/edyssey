package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ch.nostromo.edyssey.database.entities.references.Allegiance;
import ch.nostromo.edyssey.database.entities.references.Economy;
import ch.nostromo.edyssey.database.entities.references.Faction;
import ch.nostromo.edyssey.database.entities.references.FactionState;
import ch.nostromo.edyssey.database.entities.references.Government;
import ch.nostromo.edyssey.database.entities.references.Module;
import ch.nostromo.edyssey.database.entities.references.Ship;
import ch.nostromo.edyssey.database.entities.references.StationType;

@Entity
public class Station extends BaseEntity implements Serializable{


    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Column
    private String stationName;
    
    @ManyToOne
    private Allegiance stationAllegiance;

    @ManyToOne
    private Faction stationFaction;

    @ManyToOne
    private Economy stationEconomy;
    
    @Column
    private Double distFromStarLS;

    @ManyToOne
    private FactionState stationFactionState;
    
    @ManyToOne
    private Government stationGovernment;
    
    @ManyToOne
    private StationType stationType;
    
    @ManyToOne
    private StarSystem starSystem;
    
    @ManyToOne
    private Body body;
    
    @OneToMany(mappedBy="station")
    private List<StationCommodity> stationCommodities = new ArrayList<>();
    
    @OneToMany(mappedBy="station")
    private List<StationCommodityBlackMarket> stationCommoditiesBlackMarket = new ArrayList<>();

    @OneToMany(mappedBy="station")
    private List<StationCommodityProhibited> stationCommoditiesProhibited = new ArrayList<>();


    @OneToMany(mappedBy="station")
    private List<StationEconomy> stationEconomies = new ArrayList<>();


    @ManyToMany()
    private Set<Ship> shipyard = new HashSet<>();

    @ManyToMany()
    private Set<Module> outfitting = new HashSet<>();

    public Station() {
        // Default
    }
    
    public Station(StarSystem starSystem, String stationName) {
        this.starSystem = starSystem;
        this.stationName = stationName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public StarSystem getStarSystem() {
        return starSystem;
    }

    public void setStarSystem(StarSystem starSystem) {
        this.starSystem = starSystem;
    }

    public void setPrices(List<StationCommodity> stationCommodities) {
        this.stationCommodities = stationCommodities;
    }

    public Allegiance getStationAllegiance() {
        return stationAllegiance;
    }

    public void setStationAllegiance(Allegiance stationAllegiance) {
        this.stationAllegiance = stationAllegiance;
    }

    public Faction getStationFaction() {
        return stationFaction;
    }

    public void setStationFaction(Faction stationFaction) {
        this.stationFaction = stationFaction;
    }

    public Economy getStationEconomy() {
        return stationEconomy;
    }

    public void setStationEconomy(Economy stationEconomy) {
        this.stationEconomy = stationEconomy;
    }

    public Double getDistFromStarLS() {
        return distFromStarLS;
    }

    public void setDistFromStarLS(Double distFromStarLS) {
        this.distFromStarLS = distFromStarLS;
    }

    public FactionState getStationFactionState() {
        return stationFactionState;
    }

    public void setStationFactionState(FactionState stationFactionState) {
        this.stationFactionState = stationFactionState;
    }

    public Government getStationGovernment() {
        return stationGovernment;
    }

    public void setStationGovernment(Government stationGovernment) {
        this.stationGovernment = stationGovernment;
    }

    public StationType getStationType() {
        return stationType;
    }

    public void setStationType(StationType stationType) {
        this.stationType = stationType;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public List<StationCommodity> getStationCommodities() {
        return stationCommodities;
    }

    public void setStationCommodities(List<StationCommodity> stationCommodities) {
        this.stationCommodities = stationCommodities;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }


    public Set<Ship> getShipyard() {
		return shipyard;
	}

	public void setShipyard(Set<Ship> shipyard) {
		this.shipyard = shipyard;
	}

	public Set<Module> getOutfitting() {
		return outfitting;
	}

	public void setOutfitting(Set<Module> outfitting) {
		this.outfitting = outfitting;
	}

	public List<StationCommodityBlackMarket> getStationCommoditiesBlackMarket() {
		return stationCommoditiesBlackMarket;
	}

	public void setStationCommoditiesBlackMarket(List<StationCommodityBlackMarket> stationCommoditiesBlackMarket) {
		this.stationCommoditiesBlackMarket = stationCommoditiesBlackMarket;
	}

    public List<StationEconomy> getStationEconomies() {
        return stationEconomies;
    }

    public void setStationEconomies(List<StationEconomy> stationEconomies) {
        this.stationEconomies = stationEconomies;
    }

    public List<StationCommodityProhibited> getStationCommoditiesProhibited() {
        return stationCommoditiesProhibited;
    }

    public void setStationCommoditiesProhibited(List<StationCommodityProhibited> stationCommoditiesProhibited) {
        this.stationCommoditiesProhibited = stationCommoditiesProhibited;
    }
}
