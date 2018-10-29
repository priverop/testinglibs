package identify;


import utilities.XPathParser;

public class JavaIdentify extends AbstractIdentify {

    private static final String POM_FILE = "/pom.xml";
    private final String JUNIT5_ARTEFACTID = "junit-jupiter-engine";
    private final String TESTNG_ARTEFACTID = "testng";

    public JavaIdentify(String project_path){
        super(project_path, POM_FILE);
    }

    public String getJunit5ArtefactID() {
        return this.JUNIT5_ARTEFACTID;
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
