package funance.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Twilio {
    public CollectedData getCollected_data() {
        return collected_data;
    }

    public void setCollected_data(CollectedData collected_data) {
        this.collected_data = collected_data;
    }

    @JsonProperty("collected_data")
    CollectedData collected_data;
}