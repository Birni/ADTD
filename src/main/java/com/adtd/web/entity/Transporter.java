package com.adtd.web.entity;



import javax.persistence.*;


@Entity
public class Transporter
{
    @Id
    private String Label;
    private float maxPayload;
    private float battery;
    private float payload;
    private boolean hasJob = false;

    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private Node Position;

    @Embedded
    private Route route = new Route();


    public Transporter()
    {

    }

    public Transporter(String label)
    {
        this.Label = label;
    }

    public Transporter(String label, Node positon)
    {
        this.Label = label;
        this.Position = positon;
    }

    public Transporter(String label, float battery, float maxPayload)
    {
        this.Label = label;
        this.battery = battery;
        this.maxPayload = maxPayload;
    }


    public String getLabel(){
        return Label;
    }

    public void setLabel(String label){
        this.Label = label;
    }

    public float getMaxPayload(){
        return maxPayload;
    }

    public void setMaxPayload(float maxPayload){
        this.maxPayload = maxPayload;
    }

    public void setBattery(float battery)
    {
        this.battery = battery;
    }

    public float getBattery()
    {
        return this.battery;
    }

    public void setPayload(float payload)
    {
        this.payload = payload;
    }

    public void setPosition(Node position){
        this.Position = position;
    }

    public float getPayload()
    {
        return this.payload;
    }


    public void setRoute(Route route) {
        this.route = route;
    }

    public Route getRoute() {
        return route;
    }

    public boolean isHasJob()
    {
        return this.hasJob;
    }

    public Node GetPosition()
    {
        return this.Position;
    }

    public void setHasJob( boolean isHasJob){
        this.hasJob = isHasJob;
    }

    public void PropagateNewPostion(float deltatime)
    {
        //formula: https://www.igismap.com/formula-to-find-bearing-or-heading-angle-between-two-points-latitude-longitude/
        //formula: https://stackoverflow.com/questions/7222382/get-lat-long-given-current-point-distance-and-bearing

    //   double R = 6378.388 ;

    //   double lat1 = Position.Latitude.doubleValue() *Math.PI / 180;
    //   double lon1 = Position.Longitude.doubleValue()*Math.PI / 180;
    //   double lat2 = NextNodeToDrive.GetCoordinate().Latitude.doubleValue()*Math.PI / 180;
    //   double lon2 = NextNodeToDrive.GetCoordinate().Longitude.doubleValue()*Math.PI / 180;
    //   double distance =  (deltatime * 2.77778)/1000; // in this simulation transporter always drive 10 km/h

    //   double dist = R * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1));

    //   if(distance > dist)
    //   {
    //       distance -=dist;
    //
    //       jobroute.IncrementNextTargetToDrive();
    //       NextNodeToDrive = jobroute.GetRouteNodes().get(jobroute.GetNextTargetToDrive());


    //       lat1 = NextNodeToDrive.GetCoordinate().Latitude.doubleValue()*Math.PI / 180;
    //       lat2 = NextNodeToDrive.GetCoordinate().Longitude.doubleValue()*Math.PI / 180;


    //   }

    //   double X = Math.cos(lat1) * Math.sin(Math.abs((lon2-lon1)));
    //   double Y = Math.cos(lat2) * Math.sin(lat1) - Math.sin(lat2) * Math.cos(lat1) * Math.cos(Math.abs((lon2-lon1)));

    //   double brng = -Math.atan2(X,Y);
    //   double lat = lat1;
    //   double lon = lon1;



    //   lat = Math.asin(Math.sin(lat) * Math.cos(distance / R) + Math.cos(lat) * Math.sin(distance / R) * Math.cos(brng));
    //   lon += Math.atan2(Math.sin(brng) * Math.sin(distance / R) * Math.cos(lat), Math.cos(distance / R) - Math.sin(lat) * Math.sin(lat));


    //   lat = lat * 180 / Math.PI;
    //   lon = lon * 180 / Math.PI;

    //   Position.Latitude = BigDecimal.valueOf(lat);
    //   Position.Longitude = BigDecimal.valueOf(lon);

    //    jobroute.IncrementNextTargetToDrive();

    //    Position.Latitude = jobroute.GetRouteNodes().get(jobroute.GetNextTargetToDrive()).GetCoordinate().Latitude;
    //    Position.Longitude = jobroute.GetRouteNodes().get(jobroute.GetNextTargetToDrive()).GetCoordinate().Longitude;

    //    Position.Longitude = NodeCollection.getInstance().GetRandomNode().GetCoordinate().GetLongitude();
    //    Position.Latitude = NodeCollection.getInstance().GetRandomNode().GetCoordinate().GetLatitude();

    }
}
