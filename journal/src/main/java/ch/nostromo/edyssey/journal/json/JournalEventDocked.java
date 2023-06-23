package ch.nostromo.edyssey.journal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JournalEventDocked extends JournalEvent {

	@JsonProperty("StationName")
	String stationName;

	@JsonProperty("StarSystem")
	String starSystem;

	@JsonProperty("StationType")
	String stationType;

	@JsonProperty("StationFaction")
	String stationFaction;

	@JsonProperty("StationGovernment")
	String stationGovernment;

	@JsonProperty("StationGovernment_Localised")
	String stationGovernmentLocalised;

	@JsonProperty("StationEconomy")
	String stationEconomy;

	@JsonProperty("StationEconomy_Localised")
	String stationEconomyLocalised;

	@JsonProperty("DistFromStarLS")
	Double distFromStarLS;

	@JsonProperty("StationAllegiance")
	String stationAllegiance;

	@JsonProperty("FactionState")
	String factionState;

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String starSystem) {
		this.starSystem = starSystem;
	}

	public String getStationType() {
		return stationType;
	}

	public void setStationType(String stationType) {
		this.stationType = stationType;
	}

	public String getStationFaction() {
		return stationFaction;
	}

	public void setStationFaction(String stationFaction) {
		this.stationFaction = stationFaction;
	}

	public String getStationGovernment() {
		return stationGovernment;
	}

	public void setStationGovernment(String stationGovernment) {
		this.stationGovernment = stationGovernment;
	}

	public String getStationGovernmentLocalised() {
		return stationGovernmentLocalised;
	}

	public void setStationGovernmentLocalised(String stationGovernmentLocalised) {
		this.stationGovernmentLocalised = stationGovernmentLocalised;
	}

	public String getStationEconomy() {
		return stationEconomy;
	}

	public void setStationEconomy(String stationEconomy) {
		this.stationEconomy = stationEconomy;
	}

	public String getStationEconomyLocalised() {
		return stationEconomyLocalised;
	}

	public void setStationEconomyLocalised(String stationEconomyLocalised) {
		this.stationEconomyLocalised = stationEconomyLocalised;
	}

	public Double getDistFromStarLS() {
		return distFromStarLS;
	}

	public void setDistFromStarLS(Double distFromStarLS) {
		this.distFromStarLS = distFromStarLS;
	}

	public String getStationAllegiance() {
		return stationAllegiance;
	}

	public void setStationAllegiance(String stationAllegiance) {
		this.stationAllegiance = stationAllegiance;
	}

	public String getFactionState() {
		return factionState;
	}

	public void setFactionState(String factionState) {
		this.factionState = factionState;
	}

}
