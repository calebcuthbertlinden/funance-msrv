package funance.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CollectItems {
    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    @JsonProperty("answers")
    Answers answers;
}
