package presentation.mapPresenter.mapComponents;

import java.util.ArrayList;
import java.util.List;

public class Location
{
    private String type = "Feature";
    private List<Coordinate> coordinateList = new ArrayList<Coordinate>();
    private String GeometryType ="Polygon";


    public String getType()
    {
        return type;
    }

    public Location setType(String type)
    {
        this.type = type;
        return this;
    }

    public List<Coordinate> getCoordinateList()
    {
        return coordinateList;
    }


    public Location addCoordinate(Coordinate Coord)
    {
        this.coordinateList.add(Coord);
        return this;
    }

    public String getJsonString()
    {

        String jsonString = "{" +
                     "\"type\":\""+ type +"\","                          +
                     "\"geometry\":{"                                    +
                                  "\"type\":\""+ GeometryType +"\","     +
                                  "\"coordinates\": [[";
        for(int i=0; i < coordinateList.size(); i++ )
        {
             jsonString += "[" + coordinateList.get(i).getLongitude() +","+  coordinateList.get(i).getLatitude() +"]";

             if(i < coordinateList.size()-1)
             {
                 jsonString +=",";
             }


        }

        jsonString += "]]}}";


        return jsonString;
    }

}
