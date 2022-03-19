import java.io.Serializable;

abstract class Driver implements Serializable {
    private String driverName;
    private String driverLocation;
    private String teamName;

    public Driver(String driverName, String driverLocation, String teamName) {
        this.driverName = driverName;
        this.driverLocation = driverLocation;
        this.teamName = teamName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public void setDriverLocation(String driverLocation) {
        this.driverLocation = driverLocation;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean equals(Driver dr) {
        if (this.getDriverName() == dr.getDriverName()) {
            return true;
        } else {
            return false;
        }
    }
}



