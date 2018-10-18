package unit;

import unit.identify.JavaIdentifyTest;

import java.io.File;

public class TestUtils {

    public static String PROJECT_ABS_PATH;

    public static void setProjectAbsPath(String KeyFileName){
        File resfile = new File(TestUtils.class.getClassLoader().getResource(KeyFileName).getFile());
        PROJECT_ABS_PATH = resfile.getParent();
    }

    public static String getProjectAbsPath(){
        return PROJECT_ABS_PATH;
    }

}
