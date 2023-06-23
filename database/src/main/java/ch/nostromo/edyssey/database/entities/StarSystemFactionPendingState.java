package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.nostromo.edyssey.database.entities.references.PendingState;

@Entity
public class StarSystemFactionPendingState extends BaseEntity implements Serializable{


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private StarSystemFaction starSystemFaction;
    
    @ManyToOne
    private PendingState pendingState;

    @Column
    private Integer Trend;
    
    public StarSystemFactionPendingState() {

    }
    
    public StarSystemFactionPendingState(StarSystemFaction starSystemFaction) {
        this.starSystemFaction = starSystemFaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PendingState getPendingState() {
        return pendingState;
    }

    public void setPendingState(PendingState pendingState) {
        this.pendingState = pendingState;
    }

    public Integer getTrend() {
        return Trend;
    }

    public void setTrend(Integer trend) {
        Trend = trend;
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
