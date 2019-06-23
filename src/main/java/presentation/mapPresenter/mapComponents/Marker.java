package presentation.mapPresenter.mapComponents;



public class Marker {

    private MapCoordinate position;
    private String popupMsg;

    public Marker(MapCoordinate position)
    {
        this.position = position;
    }

    public Marker(MapCoordinate position, String popupMsg)
    {
        this.position = position;
        this.popupMsg = popupMsg;
    }

    public MapCoordinate getPosition() {
        return position;
    }

    public Marker setPosition(MapCoordinate position) {
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
