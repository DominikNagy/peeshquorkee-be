package sk.nagy.dominik.peeshquorkeebe.restapi.chat;

import java.sql.Timestamp;

public class ChatHistoryRequest {
    private Timestamp timestamp;

    public ChatHistoryRequest(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public ChatHistoryRequest() {
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
