package driver;

import java.io.Serializable; // abstract class

public abstract class Driver implements Serializable
{
    public static final String NO_TEAM = "no team";

    //variables
    private String driverName;
    private String driverLocation;
    private String driverTeam;

    //constructors
    public Driver( String driverName, String driverLocation, String driverTeam )
    {
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.driverTeam = driverTeam;
    }

    //getters and setters
    public String getDriverName()
    {
        return driverName;
    }

    public void setDriverName( String driverName )
    {
        this.driverName = driverName;
    }

    public String getDriverLocation()
    {
        return driverLocation;
    }

    public void setDriverLocation( String driverLocation )
    {
        this.driverLocation = driverLocation;
    }

    public String getDriverTeam()
    {
        return driverTeam;
    }

    public void setDriverTeam( String driverTeam )
    {
        this.driverTeam = driverTeam;
    }

    public abstract void printStatics();
}



