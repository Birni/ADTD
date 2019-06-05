package presentation.mapPresenter.map;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

import presentation.mapPresenter.mapComponents.Map;


@ManagedBean(name = "mapBean")
@ViewScoped
public class MapBean implements Serializable
{
    private Map myMapBean = new Map();

    public MapBean()
    {
    }

    public Map getMap() {
        return myMapBean;
    }
}
