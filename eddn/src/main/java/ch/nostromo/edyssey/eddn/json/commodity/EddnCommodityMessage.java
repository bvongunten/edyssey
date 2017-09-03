
package ch.nostromo.edyssey.eddn.json.commodity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "systemName",
    "stationName",
    "timestamp",
    "commodities"
})
public class EddnCommodityMessage {

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
    private String timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("commodities")
    private List<JsonCommodityMessageEntry> jsonCommodities = null;

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
    @JsonProperty("commodities")
    public List<JsonCommodityMessageEntry> getCommodities() {
        return jsonCommodities;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("commodities")
    public void setCommodities(List<JsonCommodityMessageEntry> jsonCommodities) {
        this.jsonCommodities = jsonCommodities;
    }

}
