
package ch.nostromo.edyssey.eddn.json.blackmarket;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import ch.nostromo.edyssey.eddn.json.EddnEnvelope;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message"
})
public class EddnBlackMarket extends EddnEnvelope {

    /**
     * Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'")
    private EddnBlackMarketMessage eddnBlackMarketMessage;

    /**
     * Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'
     * (Required)
     * 
     */
    @JsonProperty("message")
    public EddnBlackMarketMessage getMessage() {
        return eddnBlackMarketMessage;
    }

    /**
     * Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(EddnBlackMarketMessage eddnBlackMarketMessage) {
        this.eddnBlackMarketMessage = eddnBlackMarketMessage;
    }

}
