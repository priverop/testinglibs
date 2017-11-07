package listing;

// JUNIT
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// JAVA
import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 * Created by nexmaniosis on 12/10/17.
 */

public class JUnit5ListingTest {

    private static final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/junit5-vanilla-maven/";
    private static final String CURRENT_PROJECT_ABS_PATH = "/Users/nexmaniosis/testinglibs";
    private final String REPORTS_FOLDER = "/target/surefire-reports/";

    private final String TESTNAME1 = "TEST-listing.JUnit5ListingTest";
    private final String TESTNAME2 = "TEST-listing.JavaIdentifyTest";

    private static JUnit5Listing listingObject;

    @BeforeAll
    static void init(){
        listingObject = new JUnit5Listing(CURRENT_PROJECT_ABS_PATH);
    }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(CURRENT_PROJECT_ABS_PATH + REPORTS_FOLDER), listingObject.getReportsDirectory(), "Get SurefireReports Directory (FILE)");
    }

    @Test
    void getList() {
        List testList = new ArrayList<String>();
        testList.add(TESTNAME2);
        testList.add(TESTNAME1);
        assertEquals(testList, listingObject.getReportsName_filter(), "Get test list: 2 tests (XML).");
    }


}