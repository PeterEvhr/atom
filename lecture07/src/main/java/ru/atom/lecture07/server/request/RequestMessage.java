package ru.atom.lecture07.server.request;

public class RequestMessage {
    private Topic topic;
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


    private RequestData data;
    public RequestData getData() {
        return data;
    }

    public void setData(RequestData data) {
        this.data = data;
    }

}
