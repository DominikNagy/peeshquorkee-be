package sk.nagy.dominik.peeshquorkeebe.restapi.chat;

public class ChatHistoryRequest {
    private String timestamp;

    public ChatHistoryRequest(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
