package identify;


import utilities.JSonManager;

public class JSIdentify extends AbstractIdentify{

    private static final String JSON_FILE = "/package.json";
    private final String MOCHA_JSON_KEY = "name";
    private static final String MOCHA_ARTEFACTID = "mocha";

    public JSIdentify(String project_path){
        super(project_path, JSON_FILE, MOCHA_ARTEFACTID);
    }

    @Override
    public Boolean checkFramework() {
        JSonManager x = new JSonManager();
        String y = x.readAndFind(getKeyFile(), MOCHA_JSON_KEY);

        return y.equals(getFramework());
    }

}
