package presentation.mapPresenter.mapComponents;



public class Marker {

    private Coordinate position;
    private String popupMsg;

    public Marker(Coordinate position)
    {
        this.position = position;
    }

    public Marker(Coordinate position, String popupMsg)
    {
        this.position = position;
        this.popupMsg = popupMsg;
    }

    public Coordinate getPosition() {
        return position;
    }

    public Marker setPosition(Coordinate position) {
        this.position = position;
        return this;
    }

    public String getPopupMsg() {
        return popupMsg;
    }

    public Marker setPopupMsg(String popupMsg) {
        this.popupMsg = popupMsg;
        return this;
    }

    @Override
    public String toString() {
        return "Marker [position=" + position.toString()
                + ", popupMsg=" + popupMsg
                + ", pulse="
                + "]";
    }

}
