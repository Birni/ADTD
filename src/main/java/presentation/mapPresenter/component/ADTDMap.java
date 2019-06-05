package presentation.mapPresenter.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

import presentation.mapPresenter.mapComponents.Map;


@FacesComponent("adtdMap")
public class ADTDMap extends UINamingContainer
{
    private transient Map myMap;

    public Map getMyMap()
    {
        if (myMap == null)
            myMap = ((Map) this.getAttributes().get("map"));

        return myMap;
    }

}
