package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ch.nostromo.edyssey.database.entities.references.Allegiance;
import ch.nostromo.edyssey.database.entities.references.Faction;
import ch.nostromo.edyssey.database.entities.references.FactionState;
import ch.nostromo.edyssey.database.entities.references.Government;

@Entity
public class StarSystemFaction extends BaseEntity implements Serializable{


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Faction faction;

    @ManyToOne
    private Allegiance allegiance;

    @ManyToOne
    private FactionState factionState;

    @ManyToOne
    private Government government;

    @ManyToOne
    private StarSystem starSystem;

    @Column
    private double influence;
    
    @OneToMany(mappedBy="starSystemFaction", orphanRemoval=true)
    private List<StarSystemFactionPendingState> pendingStates = new ArrayList<>();
    
    @OneToMany(mappedBy="starSystemFaction", orphanRemoval=true)
    private List<StarSystemFactionRecoveringState> RecoveringStates = new ArrayList<>();
   
    public StarSystemFaction() {

    }

    public StarSystemFaction(StarSystem starSystem) {
        this.starSystem = starSystem;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public Allegiance getAllegiance() {
        return allegiance;
    }

    public void setAllegiance(Allegiance allegiance) {
        this.allegiance = allegiance;
    }

    public FactionState getFactionState() {
        return factionState;
    }

    public void setFactionState(FactionState factionState) {
        this.factionState = factionState;
    }

    public Government getGovernment() {
        return government;
    }

    public void setGovernment(Government government) {
        this.government = government;
    }

    public double getInfluence() {
        return influence;
    }

    public void setInfluence(double influence) {
        this.influence = influence;
    }

    public List<StarSystemFactionPendingState> getPendingStates() {
        return pendingStates;
    }

    public void setPendingStates(List<StarSystemFactionPendingState> pendingStates) {
        this.pendingStates = pendingStates;
    }

    public List<StarSystemFactionRecoveringState> getRecoveringStates() {
        return RecoveringStates;
    }

    public void setRecoveringStates(List<StarSystemFactionRecoveringState> recoveringStates) {
        RecoveringStates = recoveringStates;
    }


    
}
