package unit;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUtils {

    private static final Logger LOGGER = Logger.getLogger( TestUtils.class.getName() );

    private static String PROJECT_ABS_PATH;

    public static void setProjectAbsPath(String KeyFileName){
        File resource = null;
        try{
           resource = new File(TestUtils.class.getClassLoader().getResource(KeyFileName).getFile());
        }
        catch (NullPointerException e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        finally {
            if(resource != null && resource.isDirectory())
                PROJECT_ABS_PATH = resource.getPath();
            else if (resource != null) {
                PROJECT_ABS_PATH = resource.getParent();
            }
            else{
                LOGGER.log(Level.SEVERE, "Can't find resource: " +KeyFileName);
            }
        }


    }

    public static String getProjectAbsPath(){
        return PROJECT_ABS_PATH;
    }

}
