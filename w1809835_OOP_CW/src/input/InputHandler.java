package input;

import driver.Formula1Driver;

import java.util.List;

public interface InputHandler
{ //methods
    void createNewDriver();

    void deleteDriver();

    void changeTheDriver();

    void displayDriverStatics();

    List<Formula1Driver> displayFormula1DriverTable();

    void addRace();

    void saveInfoIntoFile();

    void restoreDataIntoProgram();
}
