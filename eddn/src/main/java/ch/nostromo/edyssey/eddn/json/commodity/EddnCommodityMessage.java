
package ch.nostromo.edyssey.eddn.json.commodity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "systemName",
    "stationName",
    "timestamp",
    "commodities",
        "economies",
        "marketId",
        "prohibited"
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


    @JsonProperty("economies")
    private List<Map<String, Object>> economies;

    @JsonProperty("marketId")
    private String marketId;

    @JsonProperty("prohibeted")
    private List<String> prohibited;


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


    @JsonProperty("economies")
    public List<Map<String, Object>> getEconomies() {
        return economies;
    }

    @JsonProperty("economies")
    public void setEconomies(List<Map<String, Object>> economies) {
        this.economies = economies;
    }

    @JsonProperty("marketId")
    public String getMarketId() {
        return marketId;
    }

    @JsonProperty("marketId")
    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    @JsonProperty("prohibited")
    public List<String> getProhibited() {
        return prohibited;
    }

    @JsonProperty("prohibited")
    public void setProhibited(List<String> prohibited) {
        this.prohibited = prohibited;
    }
}
