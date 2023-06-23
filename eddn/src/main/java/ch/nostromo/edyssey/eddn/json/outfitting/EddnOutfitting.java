
package ch.nostromo.edyssey.eddn.json.outfitting;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import ch.nostromo.edyssey.eddn.json.EddnEnvelope;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message"
})
public class EddnOutfitting extends EddnEnvelope {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    private EddnOutfittingMessage message;

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public EddnOutfittingMessage getMessage() {
        return message;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(EddnOutfittingMessage message) {
        this.message = message;
    }

}
