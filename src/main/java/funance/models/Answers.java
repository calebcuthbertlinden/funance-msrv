package funance.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answers {
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