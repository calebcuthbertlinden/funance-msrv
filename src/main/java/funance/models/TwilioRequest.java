package funance.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TwilioRequest {
    public Twilio getTwilio() {
        return twilio;
    }

    public void setTwilio(Twilio twilio) {
        this.twilio = twilio;
    }

    @JsonProperty("twilio")
    Twilio twilio;
}