package urjc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nexmaniosis on 12/10/17.
 */
public class ListingTests {

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
    void getFiles() {
        Listing listing = new Listing();
        assertEquals(2, listing.getFiles().size(), "2 expected.");
    }

    @Test
    void getDirectory() {
        Listing listing = new Listing();
        assertEquals(PROJECT_ABS_PATH + "target/surefire-reports/", listing.getDirectory(), "Target SurefireReports Directory");
    }
}