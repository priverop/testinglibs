package unit;

import utilities.ResourceManager;

public class TestUtils {

    private static String PROJECT_ABS_PATH;

    public static void setProjectAbsPath(String KeyFileName){
        PROJECT_ABS_PATH = ResourceManager.getResourcePath(KeyFileName);
    }

    public static String getProjectAbsPath(){
        return PROJECT_ABS_PATH;
    }

}
