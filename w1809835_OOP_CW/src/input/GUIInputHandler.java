package input;

import driver.Formula1Driver;
import input.view.GUI;
import manager.ChampionshipManager;
import manager.Formula1ChampionshipManager;
import model.Date;
import race.Race;
import input.InputHandler;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;


public class GUIInputHandler

{
    //call objects
    private GUI gui;
    private ChampionshipManager championshipManager;
    private Formula1ChampionshipManager manager;
    private InputHandler inputHandler;

    public GUIInputHandler( GUI gui, ChampionshipManager championshipManager )
    {
        this.gui = gui;
        this.championshipManager = championshipManager;
    }

    public String[][] getTableData(){//get table data
        List<Formula1Driver> drivers = this.championshipManager.getOrderedDrivers();

        if( drivers == null || drivers.isEmpty()){
            return new String[1][GUI.columns.length];
        }

        drivers.stream().forEach(System.out::println);

        String rows[][] = new String[drivers.size()][GUI.columns.length];
        int count = 0;
        for( Formula1Driver driver: drivers ){
            String[] row = new String[GUI.columns.length];

            row[0] = driver.getDriverName();
            row[1] = driver.getDriverTeam();
            row[2] = driver.getNumberOfPoints()+"";
            row[3] = driver.getNoOfFirstPositions()+"";
            row[4] = driver.getNoOfSecondPositions()+"";
            row[5] = driver.getNoOfThirdPositions()+"";

            rows[count] = row;
            count ++;
        }
        return rows;
    }
    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }

    public String getRandRace(){
        String outPut ="No Driver Details Available";

        Random rand = new Random();// to get random number
        int year = (int)Math.floor(Math.random()*(2020-2010+1)+2010);
        int month = (int)Math.floor(Math.random()*(12-1+1)+1);
        int day = (int)Math.floor(Math.random()*(31-1+1)+1);


        //System.out.println(newRandList);
        System.out.println(year +" / "+ month +" / "+ day);//print date
        String dateNew = ("Date - :" + year +" / "+ month + " / "+ day);


        try {
            List<String> newRandList = manager.driverMap.keySet().stream()
                    .map(k -> new String(k)).collect(Collectors.toList());//convert driver map into list
            ArrayList <String> newPositionList = new ArrayList<String>(newRandList.size());

            int listSize = newRandList.size();


            Date date = new Date( day, month, year );
            Race race = new Race( date );

            for (int i=0 ; i < listSize;i++){
                int randNumber = rand.nextInt(newRandList.size());

                newPositionList.add(newRandList.get(randNumber));

                newRandList.remove(randNumber);
                race.putPosition( newPositionList.get(randNumber), i );
            }
            //testing
            for (String i:newPositionList) {
                System.out.println(newPositionList);
            }
            return dateNew;

        }catch (NullPointerException e){

            System.out.println("No Driver detail Available" + e);

        }
        //return null;
        return dateNew +"\t\t "+ outPut;
    }

    public String getDriverDetails(String driverName){
        String driverDt = driverName;
        String displayNewDriver = "";

        try{
            championshipManager.displayDriverStatics(driverDt);

        }catch (NullPointerException e){
            String error = (
                    "   >>>>>>>>>> Please Enter Correct Driver Name <<<<<<<<<<  "
            );
            return error;
        }
        return displayNewDriver;
    }


    public String [][] getSortedTable(){ //store gui table data
        List<Formula1Driver> drivers = this.championshipManager.getOrderedDrivers();

        if( drivers == null || drivers.isEmpty()){
            return new String[1][GUI.columns.length];
        }

        drivers.stream().forEach(System.out::println);

        String table[][] = new String[drivers.size()][GUI.columns.length];//2d array
        int count = 0;
        for( Formula1Driver driver: drivers ){
            String[] row = new String[GUI.columns.length];

            row[0] = driver.getDriverName();
            row[1] = driver.getDriverTeam();
            row[2] = driver.getNumberOfPoints()+"";
            row[3] = driver.getNoOfFirstPositions()+"";
            row[4] = driver.getNoOfSecondPositions()+"";
            row[5] = driver.getNoOfThirdPositions()+"";

            table[count] = row;
            count ++;
        }
        Arrays.stream(table).sorted();
        return table;//return table
    }

}
