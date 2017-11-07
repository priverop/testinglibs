package identify;


import utilities.XPathParser;

public class JavaIdentify extends AbstractIdentify {

    private static final String POM_FILE = "/pom.xml";
    private static final String JUNIT5_ARTEFACTID = "junit-jupiter-engine";

    public JavaIdentify(String project_path){
        super(project_path, POM_FILE, JUNIT5_ARTEFACTID);
    }

    @Override
    public Boolean checkFramework() {
        XPathParser x = new XPathParser();
        String y = x.readAndFind(getKeyFile(), "//text() = '"+JUNIT5_ARTEFACTID+"' ");

        return Boolean.valueOf(y);
    }



}
