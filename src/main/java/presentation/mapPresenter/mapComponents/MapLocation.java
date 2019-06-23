package presentation.mapPresenter.mapComponents;

import java.util.ArrayList;
import java.util.List;

public class MapLocation
{
    private String type = "Feature";
    private List<MapCoordinate> coordinateList = new ArrayList<MapCoordinate>();
    private String GeometryType ="Polygon";


    public String getType()
    {
        return type;
    }

    public MapLocation setType(String type)
    {
        this.type = type;
        return this;
    }

    public List<MapCoordinate> getCoordinateList()
    {
        return coordinateList;
    }


    public MapLocation addCoordinate(MapCoordinate Coord)
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
