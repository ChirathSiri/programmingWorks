package manager;

import driver.Formula1Driver;
import race.Race;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;


public interface ChampionshipManager //interface
{
    // methods
    void createNewDriver( String driverName, String driverLocation, String teamName );

    void deleteDriver( String driverName );

    boolean changeTheDriver( String teamName, String driverName );

    void displayDriverStatics(String driverName);

    List<Formula1Driver> getOrderedDrivers();

    void addRace( Race race );

    void saveInfoIntoFile(String fileName);

    void restoreDataIntoProgram(String fileName);

    List<String> getDriversNamesInChampionship();
}
