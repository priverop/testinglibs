package urjc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nexmaniosis on 12/10/17.
 */
public class JUnitListing {

    private final String PROJECT_ABS_PATH = "/Users/nexmaniosis/Google Drive/Universidad/TestingLibs - DOCS/junit5-vanilla-maven/";

    /*
        The list of every test found
     */
    private List testList;

    /*

     */
    public File getDirectory(){
        return new File(PROJECT_ABS_PATH + "target/surefire-reports/");
    }

    /*

     */

    public File[] getFiles(File folder){
        return folder.listFiles();
    }

    /*

     */
    public List getTestList(){
        List testList = new ArrayList<String>();

        for(File f: getFiles(getDirectory())){
            testList.add(extractName(f));
        }

        return testList;

    }

    private String extractName(File f){
        return f.getName();
    }
}
