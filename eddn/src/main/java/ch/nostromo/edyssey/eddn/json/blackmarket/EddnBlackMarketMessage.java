
package ch.nostromo.edyssey.eddn.json.blackmarket;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "systemName",
    "stationName",
    "timestamp",
    "name",
    "sellPrice",
    "prohibited"
})
public class EddnBlackMarketMessage {

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
     * Commodity name as returned by the MarketSell entry in the Journal
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Commodity name as returned by the MarketSell entry in the Journal")
    private String name;
    /**
     * Price to sell to the market
     * (Required)
     * 
     */
    @JsonProperty("sellPrice")
    @JsonPropertyDescription("Price to sell to the market")
    private Integer sellPrice;
    /**
     * Whether the commodity is prohibited at this station
     * (Required)
     * 
     */
    @JsonProperty("prohibited")
    @JsonPropertyDescription("Whether the commodity is prohibited at this station")
    private Boolean prohibited;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     * Commodity name as returned by the MarketSell entry in the Journal
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Commodity name as returned by the MarketSell entry in the Journal
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Price to sell to the market
     * (Required)
     * 
     */
    @JsonProperty("sellPrice")
    public Integer getSellPrice() {
        return sellPrice;
    }

    /**
     * Price to sell to the market
     * (Required)
     * 
     */
    @JsonProperty("sellPrice")
    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * Whether the commodity is prohibited at this station
     * (Required)
     * 
     */
    @JsonProperty("prohibited")
    public Boolean getProhibited() {
        return prohibited;
    }

    /**
     * Whether the commodity is prohibited at this station
     * (Required)
     * 
     */
    @JsonProperty("prohibited")
    public void setProhibited(Boolean prohibited) {
        this.prohibited = prohibited;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
