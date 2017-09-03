
package ch.nostromo.edyssey.eddn.json.journal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import ch.nostromo.edyssey.eddn.json.EddnEnvelope;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EddnJournal extends EddnEnvelope {

    /**
     * Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'")
    private EddnJournalMessage message;

    /**
     * Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'
     * (Required)
     * 
     */
    @JsonProperty("message")
    public EddnJournalMessage getMessage() {
        return message;
    }

    /**
     * Contains all properties from the listed events in the client's journal minus Localised strings and the properties marked below as 'disallowed'
     * (Required)
     * 
     */
    @JsonProperty("message")
    public void setMessage(EddnJournalMessage jsonJournalMessage) {
        this.message = jsonJournalMessage;
    }

}
