package presentation.mapPresenter.mapComponents;

import java.util.ArrayList;
import java.util.List;

public class Route
{
    private List<Coordinate> coordinateList = new ArrayList<Coordinate>();
    private String type ="LineString";


    public List<Coordinate> getCoordinateList()
    {
        return coordinateList;
    }


    public Route addCoordinate(Coordinate Coord)
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
