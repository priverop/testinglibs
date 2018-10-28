package unit.listing;

import listing.TapeListing;
import unit.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TapeListingTest {

    private static final String PROJECT_FOLDER = "tape";
    private static final String TESTS_FOLDER = "test";

    private final int NUM_TEST = 12;

    private static TapeListing listingObject;

    @BeforeAll
    static void init(){
        TestUtils.setProjectAbsPath(PROJECT_FOLDER);

        listingObject = new TapeListing(TestUtils.getProjectAbsPath()); }

    @Test
    void getReportsDirectory() {
        assertEquals(new File(TestUtils.getProjectAbsPath() + File.separator + TESTS_FOLDER), listingObject.getTestsDirectory(), "Get Mocha tests Directory (FILE)");
    }

    @Test
    void getCountList() {
        assertEquals(NUM_TEST, listingObject.getReportsName_filter(false).size(), "Get test list: 1 tests (JSON).");
    }

}
