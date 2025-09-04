public class SeriesModel {
    private String seriesName;
    private int seriesAge;
    private int seriesNumberOfEpisodes;

    // Constructor to initialize the SeriesModel with values
    public SeriesModel(String seriesName, int seriesAge, int seriesNumberOfEpisodes) {
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // Getter and Setter for seriesName
    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    // Getter and Setter for seriesAge
    public int getSeriesAge() {
        return seriesAge;
    }

    public void setSeriesAge(int seriesAge) {
        this.seriesAge = seriesAge;
    }

    // Getter and Setter for seriesNumberOfEpisodes
    public int getSeriesNumberOfEpisodes() {
        return seriesNumberOfEpisodes;
    }

    public void setSeriesNumberOfEpisodes(int seriesNumberOfEpisodes) {
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // toString method to print the details of the Series
    @Override
    public String toString() {
        return "Series Name: " + seriesName + ", Age Restriction: " + seriesAge + ", Number of Episodes: " + seriesNumberOfEpisodes;
    }
}
