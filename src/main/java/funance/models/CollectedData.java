package funance.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CollectedData {
    public CollectItems getCollect_comments() {
        return collect_comments;
    }

    public void setCollect_items(CollectItems collect_comments) {
        this.collect_comments = collect_comments;
    }

    @JsonProperty("collect_comments")
    CollectItems collect_comments;
}
