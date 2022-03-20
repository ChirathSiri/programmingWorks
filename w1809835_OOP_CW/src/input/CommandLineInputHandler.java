package input;

import driver.Formula1Driver;
import manager.ChampionshipManager;
import model.Date;
import race.Race;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandLineInputHandler implements InputHandler
{
    private ChampionshipManager championshipManager;
    private Formula1Driver driver ;

    public CommandLineInputHandler( ChampionshipManager championshipManager )
    {
        this.championshipManager = championshipManager;
    }

    @Override
    public void createNewDriver()
    {
        Scanner scanner = new Scanner( System.in );
        System.out.print("Please enter driver's name: ");
        String driverName =  scanner.next();
        System.out.print("Please enter driver's location: ");
        String driverLocation =  scanner.next();
        System.out.print("Please assign driver to a team: ");
        String team =  scanner.next();

        this.championshipManager.createNewDriver( driverName, driverLocation, team );
    }

    @Override
    public void deleteDriver()
    {
        Scanner scanner = new Scanner( System.in );
        System.out.print("Please enter driver's name to delete: ");
        String driverName =  scanner.next();

        this.championshipManager.deleteDriver( driverName );
        System.out.println("Driver "+ driverName +" deleted !");
    }

    @Override
    public void changeTheDriver()
    {

        Scanner scanner = new Scanner( System.in );
        System.out.print("Please enter driver's name: ");
        String driverName =  scanner.next();
        System.out.print("Please enter driver's new team: ");
        String team =  scanner.next();

        this.championshipManager.changeTheDriver( team, driverName );

    }

    @Override
    public void displayDriverStatics() {
        Scanner scanner = new Scanner( System.in );
        System.out.print("Please enter driver's name: ");
        String driverName =  scanner.next();
        this.championshipManager.displayDriverStatics(driverName);
        //this.championshipManager.getOrderedDrivers().forEach(System.out::println);
    }

    @Override
    public List<Formula1Driver> displayFormula1DriverTable()
    {
        return this.championshipManager.getOrderedDrivers();
    }

    @Override
    public void addRace()
    {
        // fetch rivers who has a team in the championship
        List<String> drivers = this.championshipManager.getDriversNamesInChampionship();

        // get date for the race
        Scanner scanner = new Scanner( System.in );
        System.out.print("Please enter year: ");
        int year = scanner.nextInt();
        System.out.print("Please enter month: ");
        int month = scanner.nextInt();
        System.out.print("Please enter date: ");
        int day = scanner.nextInt();

        Date date = new Date( day, month, year );
        Race race = new Race( date );

        // fill driver Positions
        for( String driver: drivers )
        {
            System.out.print( "Please enter position in race for driver " + driver + ": " );
            int position = scanner.nextInt();
            race.putPosition( driver, position );
        }

        this.championshipManager.addRace( race );
    }

    @Override
    public void saveInfoIntoFile()
    {
        Scanner scanner = new Scanner( System.in );
        System.out.print("Please enter file name to save: ");
        String fileName = scanner.next();//get file name by user

        this.championshipManager.saveInfoIntoFile( fileName );
    }

    @Override
    public void restoreDataIntoProgram()
    {
        Scanner scanner = new Scanner( System.in );
        System.out.print("Please enter file name to restore: ");
        String fileName = scanner.next();//get restored file name by user

        this.championshipManager.restoreDataIntoProgram( fileName );
    }
}
