package com.adtd.web.mapComponents;
import org.springframework.stereotype.Component;

import javax.faces.bean.SessionScoped;


/**
 * Component with basic map data for the leaflet/ osm map
 *
 * @author  Matthias Birnthaler
 */
@Component
@SessionScoped
public class BasicMapData {

    private double centerLat = 49.003038;
    private double centerLong = 12.096346;
    private int zoom = 18;
    private int minZoom = 1;
    private int maxZoom = 19;
    private boolean zoomControl = false;
    private boolean zoomEnabled = true;
    private boolean draggingEnabled = true;
    private String urlTemplate = "http://{s}.tile.osm.org/{z}/{x}/{y}.png";

    public void setCenterLat(double centerLat) {
        centerLat = centerLat;
    }

    public void setCenterLong(double centerLong) {
        centerLong = centerLong;
    }

    public void setZoom(int zoom){
        this.zoom = zoom;
    }

    public void setMinZoom(int zoom){
        this.minZoom = zoom;
    }

    public void setMaxZoom(int zoom) {
        this.maxZoom = zoom;
    }

    public void setZoomControl(boolean zoomControl) {
        this.zoomControl = zoomControl;
    }

    public void setZoomEnabled(boolean zoomEnabled) {
        this.zoomControl = zoomEnabled;
    }

    public void setDraggingEnabled(boolean draggingEnabled) {
        this.draggingEnabled = draggingEnabled;
    }

    public void setUrlTemplate(String urlTemplate) {
        this.urlTemplate =urlTemplate;
    }

    public boolean isDraggingEnabled() {
        return draggingEnabled;
    }

    public boolean isZoomControl() {
        return zoomControl;
    }

    public boolean isZoomEnabled() {
        return zoomEnabled;
    }

    public double getCenterLat() {
        return centerLat;
    }

    public double getCenterLong() {
        return centerLong;
    }

    public int getMaxZoom() {
        return maxZoom;
    }

    public int getMinZoom() {
        return minZoom;
    }

    public int getZoom() {
        return zoom;
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

}

