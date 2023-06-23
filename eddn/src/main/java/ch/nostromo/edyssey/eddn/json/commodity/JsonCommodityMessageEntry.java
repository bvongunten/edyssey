
package ch.nostromo.edyssey.eddn.json.commodity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "meanPrice",
    "buyPrice",
    "stock",
    "stockBracket",
    "sellPrice",
    "demand",
    "demandBracket",
    "statusFlags"
})

public class JsonCommodityMessageEntry {

    /**
     * JCommodity name as returned by the Companion API, misspellings and all
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("JCommodity name as returned by the Companion API, misspellings and all")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meanPrice")
    private Integer meanPrice;
    /**
     * Price to buy from the market
     * (Required)
     * 
     */
    @JsonProperty("buyPrice")
    @JsonPropertyDescription("Price to buy from the market")
    private Integer buyPrice;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("stock")
    private Integer stock;
    /**
     * Note: A value of "" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase
     * (Required)
     * 
     */
    @JsonProperty("stockBracket")
    @JsonPropertyDescription("Note: A value of \"\" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase")
    private JsonCommodityMessageEntry.StockBracket stockBracket;
    /**
     * Price to sell to the market
     * (Required)
     * 
     */
    @JsonProperty("sellPrice")
    @JsonPropertyDescription("Price to sell to the market")
    private Integer sellPrice;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("demand")
    private Long demand;
    /**
     * Note: A value of "" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase
     * (Required)
     * 
     */
    @JsonProperty("demandBracket")
    @JsonPropertyDescription("Note: A value of \"\" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase")
    private JsonCommodityMessageEntry.DemandBracket demandBracket;
    @JsonProperty("statusFlags")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    private Set<String> statusFlags = null;

    /**
     * JCommodity name as returned by the Companion API, misspellings and all
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * JCommodity name as returned by the Companion API, misspellings and all
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meanPrice")
    public Integer getMeanPrice() {
        return meanPrice;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meanPrice")
    public void setMeanPrice(Integer meanPrice) {
        this.meanPrice = meanPrice;
    }

    /**
     * Price to buy from the market
     * (Required)
     * 
     */
    @JsonProperty("buyPrice")
    public Integer getBuyPrice() {
        return buyPrice;
    }

    /**
     * Price to buy from the market
     * (Required)
     * 
     */
    @JsonProperty("buyPrice")
    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("stock")
    public Integer getStock() {
        return stock;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("stock")
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * Note: A value of "" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase
     * (Required)
     * 
     */
    @JsonProperty("stockBracket")
    public JsonCommodityMessageEntry.StockBracket getStockBracket() {
        return stockBracket;
    }

    /**
     * Note: A value of "" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase
     * (Required)
     * 
     */
    @JsonProperty("stockBracket")
    public void setStockBracket(JsonCommodityMessageEntry.StockBracket stockBracket) {
        this.stockBracket = stockBracket;
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
     * 
     * (Required)
     * 
     */
    @JsonProperty("demand")
    public Long getDemand() {
        return demand;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("demand")
    public void setDemand(Long demand) {
        this.demand = demand;
    }

    /**
     * Note: A value of "" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase
     * (Required)
     * 
     */
    @JsonProperty("demandBracket")
    public JsonCommodityMessageEntry.DemandBracket getDemandBracket() {
        return demandBracket;
    }

    /**
     * Note: A value of "" indicates that the commodity is not normally sold/purchased at this station, but is currently temporarily for sale/purchase
     * (Required)
     * 
     */
    @JsonProperty("demandBracket")
    public void setDemandBracket(JsonCommodityMessageEntry.DemandBracket demandBracket) {
        this.demandBracket = demandBracket;
    }

    @JsonProperty("statusFlags")
    public Set<String> getStatusFlags() {
        return statusFlags;
    }

    @JsonProperty("statusFlags")
    public void setStatusFlags(Set<String> statusFlags) {
        this.statusFlags = statusFlags;
    }

    public enum DemandBracket {

        _0("0"),
        _1("1"),
        _2("2"),
        _3("3"),
        __EMPTY__("");
        private final String value;
        private final static Map<String, JsonCommodityMessageEntry.DemandBracket> CONSTANTS = new HashMap<String, JsonCommodityMessageEntry.DemandBracket>();

        static {
            for (JsonCommodityMessageEntry.DemandBracket c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private DemandBracket(String value) {
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
        public static JsonCommodityMessageEntry.DemandBracket fromValue(String value) {
            JsonCommodityMessageEntry.DemandBracket constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum StockBracket {

        _0("0"),
        _1("1"),
        _2("2"),
        _3("3"),
        __EMPTY__("");
        private final String value;
        private final static Map<String, JsonCommodityMessageEntry.StockBracket> CONSTANTS = new HashMap<String, JsonCommodityMessageEntry.StockBracket>();

        static {
            for (JsonCommodityMessageEntry.StockBracket c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private StockBracket(String value) {
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
        public static JsonCommodityMessageEntry.StockBracket fromValue(String value) {
            JsonCommodityMessageEntry.StockBracket constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
