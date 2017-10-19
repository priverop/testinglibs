package urjc;

// JUNIT
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
// JAVA
import java.util.ArrayList;
import java.util.List;
import java.io.File;
// MOCKITO
import org.mockito.Mock;
import com.example.mockito.MockitoExtension;


/**
 * Created by nexmaniosis on 12/10/17.
 */

@ExtendWith(MockitoExtension.class)
public class JUnitListingTest {

    private final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/junit5-vanilla-maven/";
    private final String REPORTS_FOLDER = "target/surefire-reports/";

    private final String TESTNAME1 = "TEST-com.example.project.CalculatorTests";
    private final String TESTNAME2 = "TEST-com.example.project.ViewTests";

    // MOCK
    private static JUnitListing listingObject;

    @BeforeAll
    void init(){
        listingObject = new JUnitListing();

    }

    @Test
    void getList() {
        List testList = new ArrayList<String>();
        testList.add(TESTNAME1);
        testList.add(TESTNAME2);
        assertEquals(testList, listingObject.getReports_filter_name(), "Get test list: 2 tests (XML).");
    }

    @Test
    void getDirectory() {
        assertEquals(new File(PROJECT_ABS_PATH + ), listingObject.getReportsDirectory(), "Get SurefireReports Directory (FILE)");
    }

    @Test
    void getFiles() {
        File folder = new File(PROJECT_ABS_PATH + "target/surefire-reports/");
        assertEquals(4, listingObject.getReportsNoFilter().length, "Get Files, expect 4 (2txt + 2xml).");
    }


}