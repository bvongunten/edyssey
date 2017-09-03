package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.nostromo.edyssey.database.entities.references.CommodityBlackMarket;

@Entity
public class StationCommodityBlackMarket extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private CommodityBlackMarket commodity;

	@Column
	private Integer sellPrice;

	@Column
	private Boolean prohibited;

	@ManyToOne
	private Station station;

	public StationCommodityBlackMarket() {

	}

	public StationCommodityBlackMarket(Station station) {
		this.station = station;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CommodityBlackMarket getCommodity() {
		return commodity;
	}

	public void setCommodity(CommodityBlackMarket commodity) {
		this.commodity = commodity;
	}

	public Integer getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Integer sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Boolean getProhibited() {
		return prohibited;
	}

	public void setProhibited(Boolean prohibited) {
		this.prohibited = prohibited;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
