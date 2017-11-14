package identify;


import utilities.XPathParser;

public class JavaIdentify extends AbstractIdentify {

    private static final String POM_FILE = "/pom.xml";
    private static final String JUNIT5_ARTEFACTID = "junit-jupiter-engine";
    private static final String TESTNG_ARTEFACTID = "testng";

    public JavaIdentify(String project_path){
        super(project_path, POM_FILE);
    }

    public static String getJunit5ArtefactID() {
        return JUNIT5_ARTEFACTID;
    }

    public Boolean checkJunit5() {
        XPathParser x = new XPathParser();
        String y = x.readAndFind(getKeyFile(), "//text() = '"+JUNIT5_ARTEFACTID+"' ");

        return Boolean.valueOf(y);
    }

    public Boolean checkTestNG() {
        XPathParser x = new XPathParser();
        String y = x.readAndFind(getKeyFile(), "//text() = '"+TESTNG_ARTEFACTID+"' ");

        return Boolean.valueOf(y);
    }

}
