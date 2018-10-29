package unit.listing;

import listing.TestNGListing;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import unit.TestUtils;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestNGListingTest {

    private static final String PROJECT_FOLDER = "java";
    private static final String TESTS_FOLDER = "target/surefire-reports/junitreports/";

    private final int NUM_TEST = 2;

    private static TestNGListing listingObject;

    @BeforeAll
    static void init(){
        TestUtils.setProjectAbsPath(PROJECT_FOLDER);

        listingObject = new TestNGListing(TestUtils.getProjectAbsPath());
    }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(TestUtils.getProjectAbsPath() + File.separator + TESTS_FOLDER), listingObject.getTestsDirectory(), "Get junitreports Directory (FILE)");
    }

    @Test
    void getCountTestList() {
        assertEquals(NUM_TEST, listingObject.getFilteredReports(false).size(), "Get number of tests "+NUM_TEST);
    }


}