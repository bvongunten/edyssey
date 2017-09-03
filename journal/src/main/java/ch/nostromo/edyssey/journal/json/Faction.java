package ch.nostromo.edyssey.journal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Faction {

    @JsonProperty("Name")
	String name;

    @JsonProperty("FactionState")
	String factionState;
    
    @JsonProperty("Government")
	String government;
    
    @JsonProperty("Influence")
	Double Influence;

    @JsonProperty("Allegiance")
	String allegiance;

    @JsonProperty("PendingStates")
    FactionState[] pendingStates;
    
    @JsonProperty("RecoveringStates")
    FactionState[] recoveringStates;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFactionState() {
		return factionState;
	}

	public void setFactionState(String factionState) {
		this.factionState = factionState;
	}

	public String getGovernment() {
		return government;
	}

	public void setGovernment(String government) {
		this.government = government;
	}

	public Double getInfluence() {
		return Influence;
	}

	public void setInfluence(Double influence) {
		Influence = influence;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public FactionState[] getPendingStates() {
		return pendingStates;
	}

	public void setPendingStates(FactionState[] pendingStates) {
		this.pendingStates = pendingStates;
	}

	public FactionState[] getRecoveringStates() {
		return recoveringStates;
	}

	public void setRecoveringStates(FactionState[] recoveringStates) {
		this.recoveringStates = recoveringStates;
	}
    
}
