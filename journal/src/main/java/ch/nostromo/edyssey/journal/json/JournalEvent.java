package ch.nostromo.edyssey.journal.json;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JournalEvent {

    @JsonProperty("timestamp")
    Calendar timestamp;

    @JsonProperty("event")
    String event;
    
    public String getEvent() {
        return event;
    }

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public void setEvent(String event) {
		this.event = event;
	}

    
}
