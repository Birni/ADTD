package services.entity;

import services.entity.util.StringIdEntity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQuery(
        name="Location.alle",
        query="SELECT s FROM Location AS s"
)
public class Location extends StringIdEntity
{
    private String Name;
    private LocatonType Type;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<Coordinate> CoordinateList = new ArrayList<>();

    public Location()
    {
    }

    public Location(String LocationId)
    {
        super.id = LocationId;
    }

    public Location(String LocationId, String name)
    {
        super.id = LocationId;
        this.Name = name;
    }

    public String getLocationId()
    {
        return getId();
    }

    public void setLocationId(String LocationId)
    {
        super.id = LocationId;
    }


    public Location(String LocationId, String name, LocatonType type, List<Coordinate> list )
    {
        super.id = LocationId;
        this.Name = name;
        this.Type = type;

        if(null != list)
        {
            for(Coordinate coordinate : list)
            {
                this.CoordinateList.add(coordinate);
            }

        }

    }

    public Location (String name, LocatonType type)
    {
        this.Name = name;
        this.Type = type;
    }

    public String GetName()
    {
        return Name;
    }

    public LocatonType GetLocatonType()
    {
        return Type;
    }

    public List<Coordinate> GetCoordinateList()
    {
        return CoordinateList;
    }

    public void addCoordinatList(List<Coordinate> list)
    {
        this.CoordinateList = list;
    }
}
