package unit;

import identify.JavaIdentify;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

public class JavaIdentifyTest {

    private final String POM_FILE = "/pom.xml";
    private static final String CURRENT_PROJECT_ABS_PATH = "/Users/nexmaniosis/testinglibs";

    private static JavaIdentify identifyObject;

    @BeforeAll
    static void init(){
        identifyObject = new JavaIdentify(CURRENT_PROJECT_ABS_PATH);
    }

    @Test
    void getPom() {
        assertEquals(new File(CURRENT_PROJECT_ABS_PATH+POM_FILE), identifyObject.getKeyFile(), "Get pom.xml");
    }

    @Test
    void getJunit5() {
        assertEquals("junit-jupiter-engine", identifyObject.getFramework(), "Find junit-jupiter-engine");
    }

    @Test
    void checkPom() {
        assertEquals(true, identifyObject.checkKeyFile(), "CheckPom returns true");
    }

    @Test
    void checkJunit5() {
        assertEquals(true, identifyObject.checkFramework(), "CheckJunit5 returns true");
    }
}
