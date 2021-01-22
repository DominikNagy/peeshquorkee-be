package sk.nagy.dominik.peeshquorkeebe.restapi.connections;

public class OnlineUsers {
    private int online;

    public OnlineUsers(int online) {
        this.online = online;
    }

    public OnlineUsers() {
    }

    public int getOnline() {
        return online;
    }
}
