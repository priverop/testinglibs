package urjc;

import com.oracle.javafx.jmx.json.JSONReader;

import java.io.File;

public class JSIdentify {

    private File json_directory;
    private final String JSON_FILE = "/package.json";
    private final String MOCHA_JSON_KEY = "name";
    private final String MOCHA_ARTEFACTID = "mocha";

    public JSIdentify(String project_path){
        json_directory = new File(project_path + JSON_FILE);
    }

    public File getJson() { return json_directory; }

    public String getMocha() {
        return MOCHA_ARTEFACTID;
    }

    public Boolean checkJson() {
        return getJson().exists() && !getJson().isDirectory();
    }

    public Boolean checkMocha() {
        JSonManager x = new JSonManager();
        String y = x.readAndFind(getJson(), MOCHA_JSON_KEY);

        return y.equals(MOCHA_ARTEFACTID);
    }

}
