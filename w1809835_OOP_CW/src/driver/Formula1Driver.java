package driver;

import java.io.Serializable;//import date

public class Formula1Driver extends Driver implements Comparable<Formula1Driver>, Serializable
{
    //create private variables (use encapsulation)
    private int noOfFirstPositions;
    private int noOfSecondPositions;
    private int noOfThirdPositions;
    private int numberOfPoints;
    private int noOfRaces;

    //constructor
    public Formula1Driver( String driverName, String driverLocation, String team )
    {
        super( driverName, driverLocation, team );//super (inherit)
    }

    //getters and setters

    public int getNoOfFirstPositions()
    {
        return noOfFirstPositions;
    }

    public int getNoOfSecondPositions()
    {
        return noOfSecondPositions;
    }

    public int getNoOfThirdPositions()
    {
        return noOfThirdPositions;
    }

    public int getNumberOfPoints()
    {
        return numberOfPoints;
    }

    public int getNoOfRaces()
    {
        return noOfRaces;
    }

    public void incrementNoOfFirstPositions(){
        this.noOfFirstPositions ++;
    }

    public void incrementNoOfSecondPositions(){
        this.noOfSecondPositions ++;
    }

    public void incrementNoOfThirdPositions(){
        this.noOfThirdPositions ++;
    }

    public void incrementNoOfRaces(){
        this.noOfRaces ++;
    }

    public void incrementPoints(int value){
        this.numberOfPoints += value;
    }

    public void printStatics()
    {
        System.out.println( "Driver name: " + this.getDriverName() );
        System.out.println( "Current team: " + this.getDriverTeam() );
        System.out.println( "No of First position: " + this.noOfFirstPositions );
        System.out.println( "No of Second position: " + this.noOfSecondPositions );
        System.out.println( "No of Third position: " + this.noOfThirdPositions );
        System.out.println( "Points: " + this.numberOfPoints );
        System.out.println( "No of Races participated: " + this.noOfRaces );
    }

    @Override
    public int compareTo( Formula1Driver o ) //compare method
    {
        return 1;
    }

    public int compareTo( int wins )
    {
        return ( this.getNumberOfPoints() - wins );
    }

    @Override
    public String toString() //to string method
    {
        return "Formula1Driver{" +
                       "noOfFirstPositions=" + noOfFirstPositions +
                       ", noOfSecondPositions=" + noOfSecondPositions +
                       ", noOfThirdPositions=" + noOfThirdPositions +
                       ", numberOfPoints=" + numberOfPoints +
                       ", noOfRaces=" + noOfRaces +
                       '}';
    }
}
