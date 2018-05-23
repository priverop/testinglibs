package unit;

// JUNIT
import listing.JUnit5Listing;
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

    private final String TESTNAME1 = "TEST-unit.MochaListingTest";
    private final String TESTNAME2 = "TEST-unit.JUnit5ListingTest";
    private final String TESTNAME3 = "TEST-unit.JSIdentifyTest";
    private final String TESTNAME4 = "TEST-unit.JavaIdentifyTest";
    private final String TESTNAME5 = "TEST-unit.JasmineListingTest";
    private final String TESTNAME6 = "TEST-unit.TapeListingTest";

    private static JUnit5Listing listingObject;

    @BeforeAll
    static void init(){
        listingObject = new JUnit5Listing(CURRENT_PROJECT_ABS_PATH);
    }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(CURRENT_PROJECT_ABS_PATH + REPORTS_FOLDER), listingObject.getTestsDirectory(), "Get SurefireReports Directory (FILE)");
    }

    @Test
    void getList() {
        List testList = new ArrayList<String>();
        testList.add(TESTNAME5);
        testList.add(TESTNAME4);
        testList.add(TESTNAME3);
        testList.add(TESTNAME2);
        testList.add(TESTNAME1);
        testList.add(TESTNAME6);
        assertEquals(testList, listingObject.getReportsName_filter(), "Get test list: 4 tests (XML).");
    }


}