
package ch.nostromo.edyssey.eddn.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EddnEnvelope {

    @JsonProperty("$schemaRef")
    private String schemaRef;

    @JsonProperty("header")
    private EddnHeader jsonJournalHeader;
    
    public String getSchemaRef() {
        return schemaRef;
    }

    public void setSchemaRef(String schemaRef) {
        this.schemaRef = schemaRef;
    }
    
    public EddnHeader getHeader() {
        return jsonJournalHeader;
    }

    public void setHeader(EddnHeader jsonJournalHeader) {
        this.jsonJournalHeader = jsonJournalHeader;
    }

}
