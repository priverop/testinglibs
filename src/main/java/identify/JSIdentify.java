package identify;


import utilities.JSonManager;

public class JSIdentify extends AbstractIdentify{

    private static final String JSON_FILE = "/package.json";
    private final String JSON_KEY = "name";
    private static final String MOCHA_ARTEFACTID = "mocha";
    private static final String JASMINE_ARTEFACTID = "jasmine-core";
    private static final String TAPE_ARTEFACTID = "tape";

    public JSIdentify(String project_path){
        super(project_path, JSON_FILE);
    }

    public static String getMochaArtefactID() {
        return MOCHA_ARTEFACTID;
    }

    public Boolean checkMocha() {
        JSonManager x = new JSonManager();
        String y = x.readAndFind(getKeyFile(), JSON_KEY);

        return y.equals(MOCHA_ARTEFACTID);
    }

    public Boolean checkJasmine() {
        JSonManager x = new JSonManager();
        String y = x.readAndFind(getKeyFile(), JSON_KEY);

        return y.equals(JASMINE_ARTEFACTID);
    }

    public Boolean checkTape() {
        JSonManager x = new JSonManager();
        String y = x.readAndFind(getKeyFile(), JSON_KEY);

        return y.equals(TAPE_ARTEFACTID);
    }

}
