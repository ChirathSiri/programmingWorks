package manager;

import manager.Formula1ChampionshipManager;
import driver.Driver;
import driver.Formula1Driver;
import file.FileReader;
import file.FileSaver;
import file.IOFile;
import race.Race;

import java.util.*;
import java.util.stream.Collectors;


public class Formula1ChampionshipManager implements ChampionshipManager
{
    private static final int[] points = { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };

    // map teamName with Driver Object
    public Map<String,Formula1Driver> teamDriverMap = new HashMap<>();
    // map driverName with Driver Object
    public Map<String,Formula1Driver> driverMap = new HashMap<>();
    // race list
    public List<Race> races = new ArrayList<>();

    private Formula1ChampionshipManager manager;
    private Formula1Driver driver;

    @Override
    public void createNewDriver( String driverName, String driverLocation, String teamName )
    {
        try {
            // if driver already exist
            if (this.driverMap.get(driverName) != null) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("      >>>>>>>>>>>>>>>>>>> Driver already existed! <<<<<<<<<<<<<<<<<<<<<<<<          ");
                System.out.println("------------------------------------------------------------------------------------");
                return;
            }

            // if new driver joins existing team
            if (this.teamDriverMap.keySet().contains(teamName)) {
                // remove current driver from the team
                this.teamDriverMap.get(teamName).setDriverTeam(Driver.NO_TEAM);
            }
        }catch (Exception e){
            System.out.println("Please enter valid details");
        }
        Formula1Driver driver = new Formula1Driver( driverName, driverLocation, teamName );
        this.teamDriverMap.put( teamName, driver );
        this.driverMap.put( driverName, driver );

    }

    @Override
    public void deleteDriver( String driverName )
    {
        // as per the explanation remove team when removing the player
        try {
            // remove drive from driver map
            Formula1Driver driver = this.driverMap.remove(driverName);
            // if driver not exist show error message
            if (driver == null) {
                System.out.println("No driver named: " + driverName);
            } else {
                // remove driver from team
                this.teamDriverMap.remove(driver.getDriverName());
                this.driverMap.remove(driver.getDriverName());
                this.teamDriverMap.remove(driver.getDriverTeam());
            }
        }catch (NullPointerException e){
            System.out.println("NO DRIVER NAME AS" + driverName);
        }
    }

    @Override
    public boolean changeTheDriver( String teamName, String driverName )
    {
        try { //try and catch to check if the code have any null error
            for(Formula1Driver driver:teamDriverMap.values()){
                if(driverName.equals(driver.getDriverName())){
                    driver.setDriverTeam(teamName);
                    System.out.println(" >>>>>>> Driver Team changed successfully !  <<<<<<<<<<<");
                    break;
                    //this.teamDriverMap.put(teamName, this.driverMap.get(driverName));
                }
            }
            Formula1Driver driver = this.teamDriverMap.get(teamName);
            // if team has no driver
            if (driver != null) {
                System.out.println("Team does not exist: " + teamName);
                return true;
            }

            // if driver is a new driver
            if (this.driverMap.get(driverName) == null) {
                System.out.println("------------------------------------------------------------------------------------");
                System.out.println("    >>>>>>>>>>>>>>>>>>>> Please create driver first ! <<<<<<<<<<<<<<<<<<<<<<<<<<<<< ");
                System.out.println("------------------------------------------------------------------------------------");
                return true;
            }
        }catch(NullPointerException ex){
            System.out.println(" Error " + ex);
            return false;
        }
        return true;
    }

    @Override
    public void displayDriverStatics(String driverName) {

        try{
            Formula1Driver driver= this.driverMap.get(driverName);

            //get the driver to be displayed
            System.out.println("    >>>>>>>>>>>>> Enter driver name to be displayed: <<<<<<<<<<<<<<<   ");
            //display data
            System.out.println("                                                                       ");
            System.out.println("                        DRIVER DETAILS                                 ");
            System.out.println("                                                                       ");
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("> Name of the Driver          - | "+driver.getDriverName());
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("> Location of the Driver      - | "+driver.getDriverLocation());
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("> DriverTeam Name             - | "+driver.getDriverTeam());
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("> Number of First Place       - | "+driver.getNoOfFirstPositions());
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("> Number of Second Place      - | "+driver.getNoOfSecondPositions());
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("> Number of Third Place       - | "+driver.getNoOfThirdPositions());
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("> Total Number Points         - | "+driver.getNumberOfPoints());
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("> Total Races Participated    - | "+driver.getNoOfRaces());
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("                                                                       ");
    }catch (NullPointerException e){
            System.out.println("|-------------------------------|-------------------------------------|");
            System.out.println("|        >>>>>>>>>> Please Enter Correct Driver Name <<<<<<<<<<       |");
            System.out.println("|-------------------------------|-------------------------------------|");
        }
    }


    @Override
    public List<Formula1Driver> getOrderedDrivers() {

            ArrayList<String> list = new ArrayList<String>(this.teamDriverMap.keySet());//Convert map into list
            //ArrayList<String> values = new ArrayList<String>(this.teamDriverMap.values());
            //display details
            System.out.println("-------------------------------------------------------| Sorted Driver Points Table |----------------------------------------------------------|");
            System.out.println("-------|----------------------|-------|--------------------------|------------------|------------------|-------------------|-------------------|");
            System.out.println("-------|----------------------|-------|--------------------------|------------------|------------------|-------------------|-------------------|");
            System.out.println("Name\t\t\tLocation\t\tTeam\t\t\tFirst Places\t\tSecond Places\t\tThird Places\t\t Points \t\t Races\t\t");
            System.out.println("-------|----------------------|-------|--------------------------|------------------|------------------|-------------------|-------------------|");

            //Get ordered driver data by for loop
            for (Formula1Driver driver: teamDriverMap.values()) {
                System.out.println(driver.getDriverName()+"\t\t\t"+driver.getDriverLocation()+"\t\t"+driver.getDriverTeam()+"\t\t\t\t\t"+
                        driver.getNoOfFirstPositions()+"\t\t\t\t\t"+driver.getNoOfSecondPositions()+"\t\t\t\t\t"+driver.getNoOfThirdPositions()+"\t\t\t\t\t"+
                        driver.getNumberOfPoints()+"\t\t\t\t"+driver.getNoOfRaces());

        }if(this.teamDriverMap.isEmpty()){
            return new ArrayList<>();//check array is empty or not

        }if(this.teamDriverMap.size()==1){


            return this.teamDriverMap.keySet().stream()
                    .map( k -> driverMap.get( k ) )
                    .filter(d -> d!= null)//remove null data
                    .collect( Collectors.toList() ); //convert to list
        }
        return this.teamDriverMap.keySet().stream()//Sorting map data
                                 .map( k -> driverMap.get( k ) )
                                 .filter(d -> d!= null)//remove empty data
                                 .sorted( Comparator.comparingInt(Formula1Driver::getNumberOfPoints) ) //use compare method
                                 .collect( Collectors.toList() );//covert to list



    }

    @Override
    public void addRace( Race race )
    {
        // add race to the list
        this.races.add( race );
        // update driver stats
        Map<String, Integer> driverPositions = race.getDriverPositions();
        for( String driverName: driverPositions.keySet() ){
            Formula1Driver driver = this.driverMap.get( driverName );
            int position = driverPositions.get( driverName );

            if( position == 1 )
            {
                driver.incrementNoOfFirstPositions();
            }else if( position == 2 )
            {
                driver.incrementNoOfSecondPositions();
            }else if( position == 3 )
            {
                driver.incrementNoOfThirdPositions();
            }
            // increment no of races
            driver.incrementNoOfRaces();

            //increment points
            if( position <= Formula1ChampionshipManager.points.length )
            {
                driver.incrementPoints( Formula1ChampionshipManager.points[position -1] );
            }
        }
    }

    @Override
    public void saveInfoIntoFile(String fileName)//save data in files
    {
        IOFile ioFile = new IOFile( this.teamDriverMap, this.driverMap, this.races );
        new FileSaver().saveData( ioFile, fileName );
    }

    @Override
    public void restoreDataIntoProgram(String fileName) //restore data
    {
        IOFile ioFile = new FileReader().readData(fileName);
        this.teamDriverMap = ioFile.getTeamDriverMap();
        this.driverMap = ioFile.getDriverMap();
        this.races = ioFile.getRaces();
    }

    public List<String> getDriversNamesInChampionship(){ //get names
        return this.teamDriverMap.keySet().stream()
                .map( k -> teamDriverMap.get( k ) )
                .map( d -> d.getDriverName() )
                .collect( Collectors.toList());
    }

    public void printDrivers()
    {
        System.out.println( this.teamDriverMap );
    }

    public void printTeams()
    {
        System.out.println( this.driverMap );
    }

}
