package presentation.mapPresenter.mapComponents;

import java.util.ArrayList;
import java.util.List;

public class MapRoute
{
    private List<MapCoordinate> coordinateList = new ArrayList<MapCoordinate>();
    private String type ="LineString";


    public List<MapCoordinate> getCoordinateList()
    {
        return coordinateList;
    }


    public MapRoute addCoordinate(MapCoordinate Coord)
    {
        this.coordinateList.add(Coord);
        return this;
    }


    public String getJsonString()
    {

        String jsonString = "{" +
                "\"type\":\""+ type +"\","                          +
                "\"coordinates\": [";
        for(int i=0; i < coordinateList.size(); i++ )
        {
            jsonString += "[" + coordinateList.get(i).getLongitude() +","+  coordinateList.get(i).getLatitude() +"]";

            if(i < coordinateList.size()-1)
            {
                jsonString +=",";
            }


        }

        jsonString += "]}";


        return jsonString;
    }

}
