package ch.nostromo.edyssey.journal.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FactionState {


    @JsonProperty("State")
	String state;


    @JsonProperty("Trend")
	Integer trend;


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Integer getTrend() {
		return trend;
	}


	public void setTrend(Integer trend) {
		this.trend = trend;
	}

	
}
