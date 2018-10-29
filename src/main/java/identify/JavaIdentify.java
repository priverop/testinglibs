package identify;


import utilities.XPathParser;

public class JavaIdentify extends AbstractIdentify {

    private static final String POM_FILE = "/pom.xml";
    private static final String JUNIT5_ARTIFACT_ID = "junit-jupiter-engine";
    private static final String TESTNG_ARTIFACT_ID = "testng";

    public JavaIdentify(String projectPath){
        super(projectPath, POM_FILE);
    }

    public String getJunit5ArtefactID() {
        return JUNIT5_ARTIFACT_ID;
    }

    public Boolean checkJunit5() {
        XPathParser x = new XPathParser();
        String y = x.readAndFind(getKeyFile(), "//text() = '"+ JUNIT5_ARTIFACT_ID +"' ");

        return Boolean.valueOf(y);
    }

    public Boolean checkTestNG() {
        XPathParser x = new XPathParser();
        String y = x.readAndFind(getKeyFile(), "//text() = '"+ TESTNG_ARTIFACT_ID +"' ");

        return Boolean.valueOf(y);
    }

}
