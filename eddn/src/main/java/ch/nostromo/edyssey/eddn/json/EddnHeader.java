
package ch.nostromo.edyssey.eddn.json;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "uploaderID",
    "softwareName",
    "softwareVersion",
    "gatewayTimestamp"
})
public class EddnHeader {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uploaderID")
    private String uploaderID;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("softwareName")
    private String softwareName;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("softwareVersion")
    private String softwareVersion;
    /**
     * Timestamp upon receipt at the gateway. If present, this property will be overwritten by the gateway; submitters are not intended to populate this property.
     * 
     */
    @JsonProperty("gatewayTimestamp")
    @JsonPropertyDescription("Timestamp upon receipt at the gateway. If present, this property will be overwritten by the gateway; submitters are not intended to populate this property.")
    private String gatewayTimestamp;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uploaderID")
    public String getUploaderID() {
        return uploaderID;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("uploaderID")
    public void setUploaderID(String uploaderID) {
        this.uploaderID = uploaderID;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("softwareName")
    public String getSoftwareName() {
        return softwareName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("softwareName")
    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("softwareVersion")
    public String getSoftwareVersion() {
        return softwareVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("softwareVersion")
    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    /**
     * Timestamp upon receipt at the gateway. If present, this property will be overwritten by the gateway; submitters are not intended to populate this property.
     * 
     */
    @JsonProperty("gatewayTimestamp")
    public String getGatewayTimestamp() {
        return gatewayTimestamp;
    }

    /**
     * Timestamp upon receipt at the gateway. If present, this property will be overwritten by the gateway; submitters are not intended to populate this property.
     * 
     */
    @JsonProperty("gatewayTimestamp")
    public void setGatewayTimestamp(String gatewayTimestamp) {
        this.gatewayTimestamp = gatewayTimestamp;
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
