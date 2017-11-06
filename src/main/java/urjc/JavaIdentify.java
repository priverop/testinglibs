package urjc;

import java.io.File;

public class JavaIdentify {

    private File pom_directory;
    private final String POM_FILE = "/pom.xml";
    private final String JUNIT5_ARTEFACTID = "junit-jupiter-engine";

    public JavaIdentify(String project_path){
        pom_directory = new File(project_path + POM_FILE);
    }

    public File getPom() {
        return pom_directory;
    }

    public String getJunit5() {
        return JUNIT5_ARTEFACTID;
    }

    public Boolean checkPom() {
        return getPom().exists() && !getPom().isDirectory();
    }

    public Boolean checkJunit5() {
        XPathParser x = new XPathParser();
        String y = x.readAndFind(getPom(), "//text() = '"+JUNIT5_ARTEFACTID+"' ");

        return Boolean.valueOf(y);
    }



}
