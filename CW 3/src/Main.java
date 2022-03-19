import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Formula1ChampionshipManager manager = new Formula1ChampionshipManager();
        manager.restoreDataIntoProgram();

        boolean contProgram = true;

        while(contProgram){
            System.out.println("Do you need to continue this program press Y or N :");
            String programCont = sc.next();
            programCont.toLowerCase();
            if (programCont.equals("yes") || programCont.equals("y")) {

                while (true) {
                    displayMenu(manager);
                    System.out.println(Formula1ChampionshipManager.driverList);
                    System.out.println(Formula1ChampionshipManager.fRaces);

                }
            } else if (programCont.equals("no") || programCont.equals("n")) {
                System.out.println("Thank you !");

            } else {
                System.out.println("Please enter valid input");
            }
        }
    }

    public void displayMenu(Formula1ChampionshipManager manager) {
        Scanner scanner = new Scanner(System.in);
        String userOption = "";
        boolean validation = true;


        System.out.println("=========================   Formula 1 Championship Manager   =========================");
        System.out.println("-------- Please Enter the relevant number of the command to be executed ---------");
        System.out.println("1   -   Create a Driver");
        System.out.println("2   -   Delete a Driver");
        System.out.println("3   -   Change a Driver from team");
        System.out.println("4   -   Display statistics of a given Driver");
        System.out.println("5   -   Display points table");
        System.out.println("6   -   Add a race");
        System.out.println("7   -   Save into a file");
        System.out.println(" ------- Please Enter the Command number -------- :");
        userOption = scanner.next();
        int userCommand = validateCommand(userOption);
        this.executeUserCommand(userCommand,manager);
    }

    public int validateCommand(String userOption) {
        Scanner sc = new Scanner(System.in);
            while (true) {
                try {
                    int userCommand = Integer.parseInt(userOption);
                    if (userCommand >= 1 && userCommand <= 7) {
                        return userCommand;
                    } else {
                        System.out.println("Enter an integer between 1 and 7");
                        userOption = sc.next();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter an integer value");
                    userOption = sc.next();
                }
            }
    }
    public void executeUserCommand(int userCommand,Formula1ChampionshipManager manager){
        switch (userCommand){
            case 1:
                System.out.println("1 user command");
                createNewDriver(manager);
                break;
            case 2:
                System.out.println("2 user command");
                deleteDriver(manager);
                break;
            case 3:
                System.out.println("3 user command");
                //(manager);
                break;
            case 4:
                System.out.println("4 user command");
                //(manager);
                break;
            case 5:
                System.out.println("5 user command");
                //(manager);
                break;
            case 6:
                System.out.println("6 user command");
                //(manager);
            case 7:
                System.out.println("7 user command");
                manager.saveInfoIntoFile();
                break;
        }
    }

    public void createNewDriver(Formula1ChampionshipManager manager){

        String driverName, driverLocation, teamName;
        int noOfFirstPositions, noOfSecondPositions, noOfThirdPositions, numberOfPoints,noOfRaces;

        //collect user data to create Driver
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Driver Name");
        driverName = getDriverUniqueName();  //get unique name as Driver name
        System.out.println("Enter Driver Location");
        driverLocation = scanner.next();
        System.out.println("Enter the Team Name :");
        teamName = scanner.next();
        System.out.println("Enter the number of First places in this season :");
        noOfFirstPositions = getValidatedInteger();
        System.out.println("Enter the number of Second places in this season :");
        noOfSecondPositions = getValidatedInteger();
        System.out.println("Enter the number of Third places this season :");
        noOfThirdPositions = getValidatedInteger();
        System.out.println("Enter the number of Points scored this season :");
        numberOfPoints = getValidatedInteger();
        System.out.println("Enter the number of Races drive in this season :");
        noOfRaces = getValidatedInteger();

        String[] stringInputsArr = {driverName, driverLocation, teamName};
        int[] integerInputsArr = {noOfFirstPositions, noOfSecondPositions, noOfThirdPositions, numberOfPoints,noOfRaces};

        manager.createNewDriver(stringInputsArr,integerInputsArr);
        System.out.println("Driver created successfully");
    }

    public String getDriverUniqueName(){
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        ArrayList<String> nameList = new ArrayList<>();
        for (Formula1Driver driver:Formula1ChampionshipManager.driverList) {
            nameList.add(driver.getDriverName());
        }
        while (true){
            if (nameList.contains(name)){
                System.out.println("Name already exists, enter another name");
                name=sc.next();
            }else{
                return name;
            }
        }
    }

    public String getUserEnteredDriver(){
        Scanner sc = new Scanner(System.in);
        String userEnteredDriver = sc.next();
        while (true){
            for (Formula1Driver club: Formula1ChampionshipManager.driverList){
                if (userEnteredDriver.equals(club.getDriverName())){
                    return userEnteredDriver;
                }
            }
            System.out.println("Driver with that name cannot be found, try again");
            userEnteredDriver = sc.next();
        }
    }

    public int getValidatedInteger(){
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        while (true){
            try {
                int intAnswer = Integer.parseInt(answer);
                return  intAnswer;
            }catch (NumberFormatException e){
                System.out.println("Please enter an integer value");
                answer = sc.next();
            }
        }
    }

}
