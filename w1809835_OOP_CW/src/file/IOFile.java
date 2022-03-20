package file;

import driver.Formula1Driver;
import race.Race;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOFile implements Serializable
{
    // map teamName with Driver Object
    private Map<String,Formula1Driver> teamDriverMap;
    // map driverName with Driver Object
    private Map<String,Formula1Driver> driverMap;
    // race list
    private List<Race> races;

    public IOFile( Map<String,Formula1Driver> teamDriverMap, Map<String,Formula1Driver> driverMap, List<Race> races )
    {
        this.teamDriverMap = teamDriverMap;
        this.driverMap = driverMap;
        this.races = races;
    }

    //getters and setters

    public Map<String,Formula1Driver> getTeamDriverMap()
    {
        return teamDriverMap;
    }

    public void setTeamDriverMap( Map<String,Formula1Driver> teamDriverMap )
    {
        this.teamDriverMap = teamDriverMap;
    }

    public Map<String,Formula1Driver> getDriverMap()
    {
        return driverMap;
    }

    public void setDriverMap( Map<String,Formula1Driver> driverMap )
    {
        this.driverMap = driverMap;
    }

    public List<Race> getRaces()
    {
        return races;
    }

    public void setRaces( List<Race> races )
    {
        this.races = races;
    }
}
