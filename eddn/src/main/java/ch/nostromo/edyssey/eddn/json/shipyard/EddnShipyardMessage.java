
package ch.nostromo.edyssey.eddn.json.shipyard;

import java.util.Date;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "systemName",
    "stationName",
    "timestamp",
    "ships"
})
public class EddnShipyardMessage {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("systemName")
    private String systemName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("stationName")
    private String stationName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    private Date timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ships")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    private Set<String> ships = null;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("systemName")
    public String getSystemName() {
        return systemName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("systemName")
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("stationName")
    public String getStationName() {
        return stationName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("stationName")
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ships")
    public Set<String> getShips() {
        return ships;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("ships")
    public void setShips(Set<String> ships) {
        this.ships = ships;
    }

}
