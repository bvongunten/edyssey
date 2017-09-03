package ch.nostromo.edyssey.database.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ch.nostromo.edyssey.database.entities.references.Commodity;
import ch.nostromo.edyssey.database.entities.references.CommodityBracket;

@Entity
public class StationCommodity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Commodity commodity;

	@Column
	private Integer meanPrice;

	@Column
	private Integer buyPrice;

	@Column
	private Integer stock;

	@ManyToOne
	private CommodityBracket stockBracket;

	@Column
	private Integer sellPrice;

	@Column
	private Integer demand;

	@ManyToOne
	private CommodityBracket demandBracket;

	@ElementCollection
	private Set<String> statusFlags = new HashSet<>();

	@ManyToOne
	private Station station;

	public StationCommodity() {

	}

	public StationCommodity(Station station) {
		this.station = station;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public Integer getMeanPrice() {
		return meanPrice;
	}

	public void setMeanPrice(Integer meanPrice) {
		this.meanPrice = meanPrice;
	}

	public Integer getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Integer buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(Integer sellPrice) {
		this.sellPrice = sellPrice;
	}

	public Integer getDemand() {
		return demand;
	}

	public void setDemand(Integer demand) {
		this.demand = demand;
	}

	public Set<String> getStatusFlags() {
		return statusFlags;
	}

	public void setStatusFlags(Set<String> statusFlags) {
		this.statusFlags = statusFlags;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CommodityBracket getStockBracket() {
		return stockBracket;
	}

	public void setStockBracket(CommodityBracket stockBracket) {
		this.stockBracket = stockBracket;
	}

	public CommodityBracket getDemandBracket() {
		return demandBracket;
	}

	public void setDemandBracket(CommodityBracket demandBracket) {
		this.demandBracket = demandBracket;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
