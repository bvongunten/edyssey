package ch.nostromo.edyssey.journal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JournalEventFSDJump extends JournalEvent {

	@JsonProperty("StarSystem")
	String starSystem;

	@JsonProperty("StarPos")
	Double[] starPos;

	@JsonProperty("SystemAllegiance")
	String SystemAllegiance;

	@JsonProperty("SystemEconomy")
	String SystemEconomy;

	@JsonProperty("SystemEconomy_Localised")
	String SystemEconomy_Localised;

	@JsonProperty("SystemGovernment")
	String SystemGovernment;

	@JsonProperty("SystemGovernment_Localised")
	String SystemGovernment_Localised;

	@JsonProperty("SystemSecurity")
	String SystemSecurity;

	@JsonProperty("SystemSecurity_Localised")
	String SystemSecurity_Localised;

	@JsonProperty("JumpDist")
	Double JumpDist;

	@JsonProperty("FuelUsed")
	Double FuelUsed;

	@JsonProperty("FuelLevel")
	Double FuelLevel;

	@JsonProperty("Factions")
	Faction[] factions;

	@JsonProperty("SystemFaction")
	String SystemFaction;

	@JsonProperty("FactionState")
	String FactionState;

	@JsonProperty("Powers")
	String[] powers;

	@JsonProperty("PowerplayState")
	String powerPlayState;

	
	public String getStarSystem() {
		return starSystem;
	}

	public void setStarSystem(String starSystem) {
		this.starSystem = starSystem;
	}

	public Double[] getStarPos() {
		return starPos;
	}

	public void setStarPos(Double[] starPos) {
		this.starPos = starPos;
	}

	public String getSystemAllegiance() {
		return SystemAllegiance;
	}

	public void setSystemAllegiance(String systemAllegiance) {
		SystemAllegiance = systemAllegiance;
	}

	public String getSystemEconomy() {
		return SystemEconomy;
	}

	public void setSystemEconomy(String systemEconomy) {
		SystemEconomy = systemEconomy;
	}

	public String getSystemEconomy_Localised() {
		return SystemEconomy_Localised;
	}

	public void setSystemEconomy_Localised(String systemEconomy_Localised) {
		SystemEconomy_Localised = systemEconomy_Localised;
	}

	public String getSystemGovernment() {
		return SystemGovernment;
	}

	public void setSystemGovernment(String systemGovernment) {
		SystemGovernment = systemGovernment;
	}

	public String getSystemGovernment_Localised() {
		return SystemGovernment_Localised;
	}

	public void setSystemGovernment_Localised(String systemGovernment_Localised) {
		SystemGovernment_Localised = systemGovernment_Localised;
	}

	public String getSystemSecurity() {
		return SystemSecurity;
	}

	public void setSystemSecurity(String systemSecurity) {
		SystemSecurity = systemSecurity;
	}

	public String getSystemSecurity_Localised() {
		return SystemSecurity_Localised;
	}

	public void setSystemSecurity_Localised(String systemSecurity_Localised) {
		SystemSecurity_Localised = systemSecurity_Localised;
	}

	public Double getJumpDist() {
		return JumpDist;
	}

	public void setJumpDist(Double jumpDist) {
		JumpDist = jumpDist;
	}

	public Double getFuelUsed() {
		return FuelUsed;
	}

	public void setFuelUsed(Double fuelUsed) {
		FuelUsed = fuelUsed;
	}

	public Double getFuelLevel() {
		return FuelLevel;
	}

	public void setFuelLevel(Double fuelLevel) {
		FuelLevel = fuelLevel;
	}

	public Faction[] getFactions() {
		return factions;
	}

	public void setFactions(Faction[] factions) {
		this.factions = factions;
	}

	public String getSystemFaction() {
		return SystemFaction;
	}

	public void setSystemFaction(String systemFaction) {
		SystemFaction = systemFaction;
	}

	public String getFactionState() {
		return FactionState;
	}

	public void setFactionState(String factionState) {
		FactionState = factionState;
	}

	public String[] getPowers() {
		return powers;
	}

	public void setPowers(String[] powers) {
		this.powers = powers;
	}

	public String getPowerPlayState() {
		return powerPlayState;
	}

	public void setPowerPlayState(String powerPlayState) {
		this.powerPlayState = powerPlayState;
	}

}
