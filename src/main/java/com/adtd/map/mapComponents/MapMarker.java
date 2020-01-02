package com.adtd.map.mapComponents;



public class MapMarker {

    private MapCoordinate position;
    private String popupMsg;

    public MapMarker(MapCoordinate position)
    {
        this.position = position;
    }

    public MapMarker(MapCoordinate position, String popupMsg)
    {
        this.position = position;
        this.popupMsg = popupMsg;
    }

    public MapCoordinate getPosition() {
        return position;
    }

    public MapMarker setPosition(MapCoordinate position) {
        this.position = position;
        return this;
    }

    public String getPopupMsg() {
        return popupMsg;
    }

    public MapMarker setPopupMsg(String popupMsg) {
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
