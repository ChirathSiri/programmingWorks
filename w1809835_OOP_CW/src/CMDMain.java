import driver.Formula1Driver;
import input.CommandLineInputHandler;
import input.InputHandler;
import input.view.GUI;
import manager.Formula1ChampionshipManager;
import driver.Formula1Driver;
import input.GUIInputHandler;


import java.util.Scanner;


public class CMDMain {

    //calling objects
    private Formula1ChampionshipManager manager;
    private InputHandler inputHandler;
    private Formula1Driver driver;
    private GUIInputHandler guiInputHandler;

    public static void main( String[] args ){//main method

        CMDMain CMDMain = new CMDMain();
        CMDMain.manager = new Formula1ChampionshipManager();
        CMDMain.inputHandler = new CommandLineInputHandler( CMDMain.manager );


        Scanner sc = new Scanner( System.in );

        boolean contProgram = true;

        while( contProgram )//program continue or not
        {
            System.out.println("                                                                                       ");
            System.out.println(" ************************************************************************************* ");
            System.out.println(" ------- This Project Create By - W1809835 -- ' Chirath Thusaraka Sirimanna ' -------- ");
            System.out.println(" ************************************************************************************* ");
            System.out.println("                                                                                       ");
            System.out.println("   >>>>>>>>>>>> If you running GUI Use Username and Password as 'admin' <<<<<<<<<<<<<  ");
            System.out.println("                                                                                       ");
            System.out.println("   >>>>>>>>>>>>       WElCOME TO FORMULA 1 CHAMPIONSHIP MANAGER         <<<<<<<<<<<<<  ");
            System.out.println("                                                                                       ");
            System.out.println(" * Do you need to continue this program press Y or N :-                                ");
            System.out.println("                                                                                       ");
            String programCont = sc.next();
            programCont.toLowerCase();
            //check user need to continue program or not
            if( programCont.equalsIgnoreCase( "yes" ) || programCont.equalsIgnoreCase( "y" ) ) {

                while( true )
                {
                    CMDMain.acceptCommand();
                    CMDMain.manager.printDrivers();
                }
            }
            else if( programCont.equalsIgnoreCase( "no" ) || programCont.equalsIgnoreCase( "n" ) )
            {
                System.out.println( "Thank you !" );
                contProgram = false;
            }
            else
            {
                System.out.println( "Please enter valid input" );
            }
        }
    }

    public void acceptCommand()
    { //get user option
        Scanner scanner = new Scanner( System.in );
        String userOption = "";
        boolean validation = true;

        //print menu

        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println( " ========================   Formula 1 Championship Manager   ==========================   -");
        System.out.println( "-------- Please Enter the relevant number of the command to be executed ---------         -");
        System.out.println( "PRESS [1]   ->>   Create a driver                                                         -");
        System.out.println( "PRESS [2]   ->>   Delete a driver                                                         -");
        System.out.println( "PRESS [3]   ->>   Change a driver from team                                               -");
        System.out.println( "PRESS [4]   ->>   Display statistics of a given driver                                    -");
        System.out.println( "PRESS [5]   ->>   Display points table                                                    -");
        System.out.println( "PRESS [6]   ->>   Add a race                                                              -");
        System.out.println( "PRESS [7]   ->>   Save into a file                                                        -");
        System.out.println( "PRESS [8]   ->>   Restore from a file                                                     -");
        System.out.println( "PRESS [9]   ->>   To Execute GUI                                                          -");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("                                                                                            ");
        System.out.println( " ------- >>>>>>>>>>>>>> Please Enter the Command number <<<<<<<<<<<<<< -------- :         -");
        userOption = scanner.next();

        while( !validateCommand( userOption ) ) { //Validate user command
            userOption = scanner.next();
        }

        this.executeUserCommand( Integer.parseInt( userOption ) ); //covert into integer
    }

    public boolean validateCommand( String userOption )//use try and catch to check user input in range of 1-8 numbers
    {
        try
        {
            int userCommand = Integer.parseInt( userOption );
            if( userCommand > 0 && userCommand <= 9 )
            {
                return true;
            }
            else
            {
                System.out.println( "Enter an integer from 1 to 9" );
                return false;
            }
        }
        catch( NumberFormatException e )
        {
            System.out.println( "Please enter valid input number" );
            return false;
        }
    }

    public void executeUserCommand( int userCommand )
    {
        switch( userCommand )//switch case
        {
            case 1:
                System.out.println( " >>>> [1] user command executed !." );//create driver
                this.inputHandler.createNewDriver();
                break;
            case 2:
                System.out.println( " >>>> [2] user command executed !." );//delete driver
                this.inputHandler.deleteDriver();
                break;
            case 3:
                System.out.println( " >>>> [3] user command executed !." );//change driver
                this.inputHandler.changeTheDriver();
                break;
            case 4:
                System.out.println( " >>>> [4] user command executed !." );//driver statics
                this.inputHandler.displayDriverStatics();
                break;
            case 5:
                System.out.println( " >>>> [5] user command executed !." );//sorted points table
                this.inputHandler.displayFormula1DriverTable();
                break;
            case 6:
                System.out.println( " >>>> [6] user command executed !." );//create new race
                this.inputHandler.addRace();
                break;
            case 7:
                System.out.println( " >>>> [7] user command executed !." );//save data in txt files
                this.inputHandler.saveInfoIntoFile();
                break;
            case 8:
                System.out.println( " >>>> [8] user command executed !." );//get already save data file
                this.inputHandler.restoreDataIntoProgram();
                break;
            case 9:
                System.out.println( " >>>> [9] user command executed !." );//execute GUI
                System.out.println( "GUI executed in your screen !!");
                GUIMain nt = new GUIMain();
                break;
            default:
                System.out.println( " ------- >>>>>>>>>>>>>> Please Enter the Command number <<<<<<<<<<<<<< -------   -");
                break;
        }
    }

}
