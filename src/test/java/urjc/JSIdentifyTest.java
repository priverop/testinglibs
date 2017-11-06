package urjc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSIdentifyTest {

    private final String JSON_FILE = "/package.json";
    private static final String PROJECT_ABS_PATH ="/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/mocha";
    private static final String CURRENT_PROJECT_ABS_PATH = "/Users/nexmaniosis/testinglibs";

    private static JSIdentify identifyObject;

    @BeforeAll
    static void init(){
        identifyObject = new JSIdentify(PROJECT_ABS_PATH);
    }

    @Test
    void getJson() {
        assertEquals(new File(PROJECT_ABS_PATH+JSON_FILE), identifyObject.getJson(), "Get package.json");
    }

    @Test
    void getMocha() {
        assertEquals("mocha", identifyObject.getMocha(), "Find name: mocha");
    }

    @Test
    void checkJson() {
        assertEquals(true, identifyObject.checkJson(), "CheckJson returns true");
    }

    @Test
    void checkMocha() {
        assertEquals(true, identifyObject.checkMocha(), "CheckMocha returns true");
    }
}
