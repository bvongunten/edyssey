
package ch.nostromo.edyssey.eddn.json.journal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timestamp",
    "event",
    "StarSystem",
    "StarPos",
    "CockpitBreach",
    "BoostUsed",
    "FuelLevel",
    "FuelUsed",
    "JumpDist",
    "Latitude",
    "Longitude"
})
public class EddnJournalMessage {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    private String timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("event")
    private EddnJournalMessage.Event event;
    /**
     * Must be added by the sender if not present in the journal event
     * (Required)
     * 
     */
    @JsonProperty("StarSystem")
    @JsonPropertyDescription("Must be added by the sender if not present in the journal event")
    private String starSystem;
    /**
     * Must be added by the sender if not present in the journal event
     * (Required)
     * 
     */
    @JsonProperty("StarPos")
    @JsonPropertyDescription("Must be added by the sender if not present in the journal event")
    private List<Double> starPos = null;
    @JsonProperty("CockpitBreach")
    private Object cockpitBreach;
    @JsonProperty("BoostUsed")
    private Object boostUsed;
    @JsonProperty("FuelLevel")
    private Object fuelLevel;
    @JsonProperty("FuelUsed")
    private Object fuelUsed;
    @JsonProperty("JumpDist")
    private Object jumpDist;
    @JsonProperty("Latitude")
    private Object latitude;
    @JsonProperty("Longitude")
    private Object longitude;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("event")
    public EddnJournalMessage.Event getEvent() {
        return event;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("event")
    public void setEvent(EddnJournalMessage.Event event) {
        this.event = event;
    }

    /**
     * Must be added by the sender if not present in the journal event
     * (Required)
     * 
     */
    @JsonProperty("StarSystem")
    public String getStarSystem() {
        return starSystem;
    }

    /**
     * Must be added by the sender if not present in the journal event
     * (Required)
     * 
     */
    @JsonProperty("StarSystem")
    public void setStarSystem(String starSystem) {
        this.starSystem = starSystem;
    }

    /**
     * Must be added by the sender if not present in the journal event
     * (Required)
     * 
     */
    @JsonProperty("StarPos")
    public List<Double> getStarPos() {
        return starPos;
    }

    /**
     * Must be added by the sender if not present in the journal event
     * (Required)
     * 
     */
    @JsonProperty("StarPos")
    public void setStarPos(List<Double> starPos) {
        this.starPos = starPos;
    }

    @JsonProperty("CockpitBreach")
    public Object getCockpitBreach() {
        return cockpitBreach;
    }

    @JsonProperty("CockpitBreach")
    public void setCockpitBreach(Object cockpitBreach) {
        this.cockpitBreach = cockpitBreach;
    }

    @JsonProperty("BoostUsed")
    public Object getBoostUsed() {
        return boostUsed;
    }

    @JsonProperty("BoostUsed")
    public void setBoostUsed(Object boostUsed) {
        this.boostUsed = boostUsed;
    }

    @JsonProperty("FuelLevel")
    public Object getFuelLevel() {
        return fuelLevel;
    }

    @JsonProperty("FuelLevel")
    public void setFuelLevel(Object fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    @JsonProperty("FuelUsed")
    public Object getFuelUsed() {
        return fuelUsed;
    }

    @JsonProperty("FuelUsed")
    public void setFuelUsed(Object fuelUsed) {
        this.fuelUsed = fuelUsed;
    }

    @JsonProperty("JumpDist")
    public Object getJumpDist() {
        return jumpDist;
    }

    @JsonProperty("JumpDist")
    public void setJumpDist(Object jumpDist) {
        this.jumpDist = jumpDist;
    }

    @JsonProperty("Latitude")
    public Object getLatitude() {
        return latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("Longitude")
    public Object getLongitude() {
        return longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public enum Event {

        DOCKED("Docked"),
        FSD_JUMP("FSDJump"),
        SCAN("Scan"),
        LOCATION("Location");
        private final String value;
        private final static Map<String, EddnJournalMessage.Event> CONSTANTS = new HashMap<String, EddnJournalMessage.Event>();

        static {
            for (EddnJournalMessage.Event c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Event(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static EddnJournalMessage.Event fromValue(String value) {
            EddnJournalMessage.Event constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
