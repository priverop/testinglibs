package urjc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by nexmaniosis on 12/10/17.
 */
public class ListingTest {

    private final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/junit5-vanilla-maven/";

    private final String TESTNAME1 = "TEST-com.example.project.CalculatorTests";
    private final String TESTNAME2 = "TEST-com.example.project.ViewTests";

    @Test
    void getList() {
        Listing listing = new Listing();
        List testList = new ArrayList<String>();
        testList.add(TESTNAME1);
        testList.add(TESTNAME2);
        assertEquals(testList, listing.getTestList(), "2 tests.");
    }

    @Test
    void getDirectory() {
        Listing listing = new Listing();
        assertEquals(PROJECT_ABS_PATH + "target/surefire-reports/", listing.getDirectory(), "Target SurefireReports Directory");
    }

    @Test
    void getFiles() {
        Listing listing = new Listing();
        File folder = new File(PROJECT_ABS_PATH + "target/surefire-reports/");
        assertEquals(2, listing.getFiles(folder).length, "2 expected.");
    }


}