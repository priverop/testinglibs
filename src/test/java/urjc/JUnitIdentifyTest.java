package urjc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

public class JUnitIdentifyTest {

    private final String POM_FILE = "pom.xml";
    private static final String CURRENT_PROJECT_ABS_PATH = "/Users/nexmaniosis/testinglibs";

    private static JUnitIdentify identifyObject;

    @BeforeAll
    static void init(){
        identifyObject = new JUnitIdentify(CURRENT_PROJECT_ABS_PATH);
    }

    @Test
    void getPom() {
        assertEquals(new File(POM_FILE), identifyObject.getPom(), "Get pom.xml");
    }

    @Test
    void getJunit5() {
        assertEquals("junit-jupiter-engine", identifyObject.getJunit5(), "Find junit-jupiter-engine");
    }

    @Test
    void checkPom() {
        assertEquals(true, identifyObject.checkPom(), "CheckPom returns true");
    }

    @Test
    void checkJunit5() {
        assertEquals(true, identifyObject.checkJunit5(), "CheckJunit5 returns true");
    }
}
