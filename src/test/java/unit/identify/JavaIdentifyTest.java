package unit.identify;

import identify.JavaIdentify;
import unit.TestUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;

public class JavaIdentifyTest {

    private static final String POM_FILE = "pom.xml";

    private static JavaIdentify identifyObject;

    @BeforeAll
    static void init(){
        TestUtils.setProjectAbsPath(POM_FILE);

        identifyObject = new JavaIdentify(TestUtils.getProjectAbsPath());
    }

    @Test
    void checkKeyFile(){
        assertEquals(true, identifyObject.checkKeyFile());
    }

    @Test
    void getPom() {
        assertEquals(new File(TestUtils.getProjectAbsPath() + File.separator + POM_FILE), identifyObject.getKeyFile(), "Get pom.xml");
    }

    @Test
    void getJunit5() {
        assertEquals("junit-jupiter-engine", identifyObject.getJunit5ArtefactID(), "Find junit-jupiter-engine");
    }

    @Test
    void checkPom() {
        assertEquals(true, identifyObject.checkKeyFile(), "CheckPom returns true");
    }

    @Test
    void checkJunit5() {
        assertEquals(true, identifyObject.checkJunit5(), "CheckJunit5 returns true");
    }

    @Test
    void checkTestNG() {
        assertEquals(false, identifyObject.checkTestNG(), "CheckTestNG returns false");
    }
}
