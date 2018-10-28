package unit.listing;

// JUNIT
import listing.JUnit5Listing;
import unit.TestUtils;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;


public class JUnit5ListingTest {

    private static final String PROJECT_FOLDER = "java";
    private static final String TESTS_FOLDER = "target/surefire-reports";

    private final int NUM_TEST = 2;

    private static JUnit5Listing listingObject;

    @BeforeAll
    static void init(){
        TestUtils.setProjectAbsPath(PROJECT_FOLDER);

        listingObject = new JUnit5Listing(TestUtils.getProjectAbsPath());
    }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(TestUtils.getProjectAbsPath() + File.separator + TESTS_FOLDER), listingObject.getTestsDirectory(), "Get SurefireReports Directory (FILE)");
    }

    @Test
    void getCountTestList() {
        assertEquals(NUM_TEST, listingObject.getReportsName_filter(false).size(), "Get number of tests "+NUM_TEST);
    }


}