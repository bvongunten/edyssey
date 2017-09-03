package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.nostromo.edyssey.database.entities.references.RecoveringState;

@Entity
public class StarSystemFactionRecoveringState extends BaseEntity implements Serializable{


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne
    private StarSystemFaction starSystemFaction;
    
    @ManyToOne
    private RecoveringState recoveringState;

    @Column
    private Integer Trend;
    
    public StarSystemFactionRecoveringState() {

    }
    
    public StarSystemFactionRecoveringState(StarSystemFaction starSystemFaction) {
        this.starSystemFaction = starSystemFaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTrend() {
        return Trend;
    }

    public void setTrend(Integer trend) {
        Trend = trend;
    }

    public RecoveringState getRecoveringState() {
        return recoveringState;
    }

    public void setRecoveringState(RecoveringState recoveringState) {
        this.recoveringState = recoveringState;
    }

    public StarSystemFaction getBoundFaction() {
        return starSystemFaction;
    }

    public void setBoundFaction(StarSystemFaction starSystemFaction) {
        this.starSystemFaction = starSystemFaction;
    }

    public StarSystemFaction getStarSystemFaction() {
        return starSystemFaction;
    }

    public void setStarSystemFaction(StarSystemFaction starSystemFaction) {
        this.starSystemFaction = starSystemFaction;
    }

    
}
