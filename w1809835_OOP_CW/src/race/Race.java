package race;

import model.Date;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Race implements Serializable
{
    private Date date;
    // maps driver name with marks
    private Map<String,Integer> driverPositions;

    public Race(Date date)
    {
        this.date = date;
        this.driverPositions = new HashMap<>();
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate( Date date )
    {
        this.date = date;
    }

    public void putPosition(String driverName, int position)
    {
        this.driverPositions.put( driverName, position );
    }

    public Map<String,Integer> getDriverPositions()
    {
        return driverPositions;
    }
}
