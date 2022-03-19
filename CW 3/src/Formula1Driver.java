public class Formula1Driver extends Driver implements Comparable<Formula1Driver> {
    private static final int[] points = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

    private int noOfFirstPositions;
    private int noOfSecondPositions;
    private int noOfThirdPositions;
    private int numberOfPoints;
    private int noOfRaces;

    public Formula1Driver(String driverName, String driverLocation, String teamName, int noOfFirstPositions, int noOfSecondPositions, int noOfThirdPositions, int numberOfPoints, int noOfRaces) {
        super(driverName, driverLocation, teamName);
        this.noOfFirstPositions = noOfFirstPositions;
        this.noOfSecondPositions = noOfSecondPositions;
        this.noOfThirdPositions = noOfThirdPositions;
        this.numberOfPoints = numberOfPoints;
        this.noOfRaces = noOfRaces;
    }

    public int getNoOfFirstPositions() {
        return noOfFirstPositions;
    }

    public void setNoOfFirstPositions(int noOfFirstPositions) {

        this.noOfFirstPositions = noOfFirstPositions;
    }

    public int getNoOfSecondPositions() {
        return noOfSecondPositions;
    }

    public void setNoOfSecondPositions(int noOfSecondPositions) {
        this.noOfSecondPositions = noOfSecondPositions;
    }

    public int getNoOfThirdPositions() {
        return noOfThirdPositions;
    }

    public void setNoOfThirdPositions(int noOfThirdPositions) {
        this.noOfThirdPositions = noOfThirdPositions;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }


    public int getNoOfRaces() {
        return noOfRaces;
    }

    public void setNoOfRaces(int noOfRaces) {
        this.noOfRaces = noOfRaces;
    }

    @Override
    public int compareTo(Formula1Driver o) {
        return (this.getNumberOfPoints() - o.getNumberOfPoints());
    }

    public int compareTo(int wins) {
        return (this.getNumberOfPoints() - wins);
    }
}
