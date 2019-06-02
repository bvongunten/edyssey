package ch.nostromo.edyssey.database.entities;

import ch.nostromo.edyssey.database.entities.references.Commodity;
import ch.nostromo.edyssey.database.entities.references.CommodityBracket;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class StationCommodityProhibited extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Commodity commodity;

	@ManyToOne
	private Station station;

	public StationCommodityProhibited() {

	}

	public StationCommodityProhibited(Station station) {
		this.station = station;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
