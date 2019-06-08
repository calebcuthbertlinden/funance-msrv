package funance.controllers;

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

class Twilio {
    public CollectedData getCollected_data() {
        return collected_data;
    }

    public void setCollected_data(CollectedData collected_data) {
        this.collected_data = collected_data;
    }

    @JsonProperty("collected_data")
    CollectedData collected_data;
}

class CollectedData {
    public CollectItems getCollect_comments() {
        return collect_comments;
    }

    public void setCollect_items(CollectItems collect_comments) {
        this.collect_comments = collect_comments;
    }

    @JsonProperty("collect_comments")
    CollectItems collect_comments;
}

class CollectItems {
    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        this.answers = answers;
    }

    @JsonProperty("answers")
    Answers answers;
}

class Answers {
    public Answer getCategory() {
        return category;
    }

    public void setCategory(Answer category) {
        this.category = category;
    }

    public Answer getValue() {
        return value;
    }

    public void setValue(Answer value) {
        this.value = value;
    }

    public Answer getTitle() {
        return title;
    }

    public void setTitle(Answer title) {
        this.title = title;
    }

    @JsonProperty("category")
    Answer category;
    @JsonProperty("value")
    Answer value;
    @JsonProperty("title")
    Answer title;
}

class Answer {
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @JsonProperty("answer")
    String answer;
}

class MessagingWhatsapp {

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    @JsonProperty("From")
    String From;
}

