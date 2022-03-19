import java.util.ArrayList;
import java.io.File;
import java.io.IOException;


public interface ChampionshipManager {
    void createNewDriver(String[] stringArr, int[] intArr);

    void deleteDriver(String driverName);

    Driver changeTheDriver(String driverName);

    void displayDriverStatics();

    ArrayList displayFormula1DriverTable();

    void addRace(Driver number01, Driver number02, int pointNo1, int pointNo2);

    void saveInfoIntoFile();

    void restoreDataIntoProgram();
}
