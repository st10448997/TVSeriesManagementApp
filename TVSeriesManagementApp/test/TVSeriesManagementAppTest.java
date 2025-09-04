import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class TVSeriesManagementAppTest {

    private Series seriesManager;

    @Before
    public void setUp() {
        seriesManager = new Series();
    }

    @Test
    public void testCaptureSeries() {
        String input = "Breaking Bad\n18\n62\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        seriesManager.captureSeries(scanner);

        assertEquals("Series should be added to the list.", 1, seriesManager.getSeriesCount());
    }

    @Test
    public void testSearchSeriesFound() {
        // Add one series
        String addInput = "Breaking Bad\n18\n62\n";
        seriesManager.captureSeries(new Scanner(new ByteArrayInputStream(addInput.getBytes())));

        // Now search for it with "do nothing" option
        String searchInput = "Breaking Bad\n3\n";
        seriesManager.searchSeries(new Scanner(new ByteArrayInputStream(searchInput.getBytes())));

        assertEquals("Series should still exist after searching.", 1, seriesManager.getSeriesCount());
    }

    @Test
    public void testSearchSeriesNotFound() {
        String searchInput = "Nonexistent\n";
        seriesManager.searchSeries(new Scanner(new ByteArrayInputStream(searchInput.getBytes())));

        assertEquals("Database should remain empty.", 0, seriesManager.getSeriesCount());
    }

    @Test
    public void testUpdateSeries() {
        // Add one series
        String addInput = "Breaking Bad\n18\n62\n";
        seriesManager.captureSeries(new Scanner(new ByteArrayInputStream(addInput.getBytes())));

        // Search + choose option 1 (update) + change episodes
        String updateInput = "Breaking Bad\n1\n\n16\n100\n"; 
        // "" keeps old name, "16" updates age, "100" updates episodes
        seriesManager.searchSeries(new Scanner(new ByteArrayInputStream(updateInput.getBytes())));

        assertEquals("Series should still exist after update.", 1, seriesManager.getSeriesCount());
    }

    @Test
    public void testDeleteSeries() {
        String addInput = "Breaking Bad\n18\n62\n";
        seriesManager.captureSeries(new Scanner(new ByteArrayInputStream(addInput.getBytes())));

        String deleteInput = "Breaking Bad\nY\n";
        seriesManager.deleteSeries(new Scanner(new ByteArrayInputStream(deleteInput.getBytes())));

        assertEquals("Series should be deleted.", 0, seriesManager.getSeriesCount());
    }

    @Test
    public void testViewSeriesReport() {
        String addInput = "Breaking Bad\n18\n62\n";
        seriesManager.captureSeries(new Scanner(new ByteArrayInputStream(addInput.getBytes())));

        seriesManager.viewSeriesReport();

        assertTrue("Series report should show at least one series.", seriesManager.getSeriesCount() > 0);
    }
}
