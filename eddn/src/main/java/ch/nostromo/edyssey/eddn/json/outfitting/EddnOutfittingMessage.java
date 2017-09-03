
package ch.nostromo.edyssey.eddn.json.outfitting;

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
    "modules"
})
public class EddnOutfittingMessage {

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
    @JsonProperty("modules")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    private Set<String> modules = null;

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
    @JsonProperty("modules")
    public Set<String> getModules() {
        return modules;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("modules")
    public void setModules(Set<String> modules) {
        this.modules = modules;
    }

}
