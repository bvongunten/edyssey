package ch.nostromo.edyssey.database.entities;

import ch.nostromo.edyssey.database.entities.references.Economy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StationEconomy extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Economy economy;

    @Column
    private Double proportion;

    @ManyToOne
    private Station station;

    public StationEconomy() {

    }

    public StationEconomy(Station station) {
        this.station = station;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Economy getEconomy() {
        return economy;
    }

    public void setEconomy(Economy economy) {
        this.economy = economy;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
