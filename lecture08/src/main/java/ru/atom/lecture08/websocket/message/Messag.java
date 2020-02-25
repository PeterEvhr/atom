package ru.atom.lecture08.websocket.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class Messag {
    private final Topi topic;
    private final String data;

    public Messag(Topi topic, String data) {
        this.topic = topic;
        this.data = data;
    }

    @JsonCreator
    public Messag(@JsonProperty("topic") Topi topic, @JsonProperty("data") JsonNode data) {
        this.topic = topic;
        this.data = data.toString();
    }

    Topi getTopic() {
        return topic;
    }

    String getData() {
        return data;
    }
}
