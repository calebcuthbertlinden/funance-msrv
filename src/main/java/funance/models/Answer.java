package funance.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @JsonProperty("answer")
    String answer;
}