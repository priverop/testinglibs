package urjc;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by nexmaniosis on 12/10/17.
 */
public class JUnitListingTest {

    private final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/junit5-vanilla-maven/";

    private final String TESTNAME1 = "TEST-com.example.project.CalculatorTests";
    private final String TESTNAME2 = "TEST-com.example.project.ViewTests";

    @Test
    void getList() {
        JUnitListing listing = new JUnitListing();
        List testList = new ArrayList<String>();
        testList.add(TESTNAME1);
        testList.add(TESTNAME2);
        assertEquals(testList, listing.getTestList(), "2 tests.");
    }

    @Test
    void getDirectory() {
        JUnitListing listing = new JUnitListing();
        assertEquals(PROJECT_ABS_PATH + "target/surefire-reports/", listing.getDirectory(), "Target SurefireReports Directory");
    }

    @Test
    void getFiles() {
        JUnitListing listing = new JUnitListing();
        File folder = new File(PROJECT_ABS_PATH + "target/surefire-reports/");
        assertEquals(2, listing.getFiles(folder).length, "2 expected.");
    }


}