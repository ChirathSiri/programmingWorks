
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Formula1ChampionshipManager implements ChampionshipManager {
    public static ArrayList<Formula1Driver> driverList = new ArrayList<Formula1Driver>();
    public static ArrayList<Formula1Driver> fRaces = new ArrayList<Formula1Driver>();


    //public static boolean MainMenu = true ;
    // public static boolean SubMenu = true ;

    //Formula1ChampionshipManager dr = new Formula1ChampionshipManager();

    //Scanner sc = new Scanner(System.in);

    //for(int x = 0; x<10; x++){
    //driverName[x] = sc.nextLine();
    //}

    //Formula1ChampionshipManager dr = new Formula1ChampionshipManager();
    //dr.createNewDriver();
    // System.out.println(dr.driverName);

    @Override
    public void createNewDriver(String[] stringArr, int[] intArr) {
        String driverName, driverLocation, teamName;
        int noOfFirstPositions, noOfSecondPositions, noOfThirdPositions, numberOfPoints,noOfRaces;
        driverName = stringArr[0];
        driverLocation = stringArr[1];
        teamName = stringArr[2];

        noOfFirstPositions = intArr[0];
        noOfSecondPositions = intArr[1];
        noOfThirdPositions = intArr[2];
        numberOfPoints = intArr[3];
        noOfRaces = intArr[4];


        Formula1Driver newDriver = new Formula1Driver(
                driverName,driverLocation,teamName,
                noOfFirstPositions, noOfSecondPositions, noOfThirdPositions, numberOfPoints,noOfRaces);
            driverList.add(newDriver);

    }


    @Override
    public void deleteDriver(String driverName) {
        int deletingIndex= 0;

        for (Formula1Driver driver:driverList){
            if (driverName.equals(driver.getDriverName())){
                deletingIndex = driverList.indexOf(driver);
                break;
            }
        }

        System.out.println("Deleting "+ driverName);
        driverList.remove(deletingIndex);
    }

    @Override
    public Driver changeTheDriver(String driverName) {
        return null;
    }

    @Override
    public void displayDriverStatics() {

    }

    @Override
    public ArrayList displayFormula1DriverTable() {
        return null;
    }

    @Override
    public void addRace(Driver number01, Driver number02, int pointNo1, int pointNo2) {

    }

    @Override
    public void saveInfoIntoFile() {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("F1_Driver_List.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Formula1Driver driver:driverList) {
                objectOutputStream.writeObject(driver);
            }
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File cannot be found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        saveRaceData();
    }

    @Override
    public void restoreDataIntoProgram() {
        FileInputStream fileInputStream = null;
        ArrayList<Formula1Driver> listOfDrivers = new ArrayList<>();
        try{
            File file = new File("F1_Driver_List.txt");
            fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            try{
                while (true){
                    Object driver;
                    driver = objectInputStream.readObject();
                    listOfDrivers.add((Formula1Driver) driver);
                }
            }catch (EOFException e){
            }
            driverList=listOfDrivers;
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File cannot be found");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        loadMatchList();
    }

    public void loadMatchList(){
        try {
            FileInputStream fileInputStream = new FileInputStream("Races.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Formula1ChampionshipManager.fRaces = (ArrayList<Formula1Driver>) objectInputStream.readObject();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveRaceData(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Races.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(Formula1ChampionshipManager.fRaces);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("File cannot be found");
            e.printStackTrace();
        }
    }

}
