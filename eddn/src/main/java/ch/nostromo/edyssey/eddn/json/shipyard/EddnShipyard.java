
package ch.nostromo.edyssey.eddn.json.shipyard;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import ch.nostromo.edyssey.eddn.json.EddnEnvelope;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "message" })
public class EddnShipyard extends EddnEnvelope {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("message")
	private EddnShipyardMessage message;

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("message")
	public EddnShipyardMessage getMessage() {
		return message;
	}

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("message")
	public void setMessage(EddnShipyardMessage message) {
		this.message = message;
	}

}
