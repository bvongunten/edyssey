
package ch.nostromo.edyssey.eddn.json.commodity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import ch.nostromo.edyssey.eddn.json.EddnEnvelope;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message"
})
public class EddnCommodity extends EddnEnvelope {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    private EddnCommodityMessage message;

  
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public EddnCommodityMessage getMessage() {
        return message;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(EddnCommodityMessage jsonMessage) {
        this.message = jsonMessage;
    }

}
