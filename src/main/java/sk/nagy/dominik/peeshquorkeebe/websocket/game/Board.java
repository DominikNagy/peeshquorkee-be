package sk.nagy.dominik.peeshquorkeebe.websocket.game;

public class Board {
    private final String f00;
    private final String f01;
    private final String f02;
    private final String f10;
    private final String f11;
    private final String f12;
    private final String f20;
    private final String f21;
    private final String f22;

    public Board(String f00, String f01, String f02, String f10, String f11, String f12, String f20, String f21, String f22) {
        this.f00 = f00;
        this.f01 = f01;
        this.f02 = f02;
        this.f10 = f10;
        this.f11 = f11;
        this.f12 = f12;
        this.f20 = f20;
        this.f21 = f21;
        this.f22 = f22;
    }

    public String getF00() {
        return f00;
    }

    public String getF01() {
        return f01;
    }

    public String getF02() {
        return f02;
    }

    public String getF10() {
        return f10;
    }

    public String getF11() {
        return f11;
    }

    public String getF12() {
        return f12;
    }

    public String getF20() {
        return f20;
    }

    public String getF21() {
        return f21;
    }

    public String getF22() {
        return f22;
    }
}
