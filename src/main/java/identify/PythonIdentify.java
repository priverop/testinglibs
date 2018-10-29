package identify;

import java.io.File;
import java.util.logging.Level;

public class PythonIdentify {

    private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger( PythonIdentify.class.getName() );

    private static final String PYTHON_EXTENSION = ".py";
    private File projectDir;

    // Why not abstract??
    public PythonIdentify(String projectPath){
        projectDir = new File(projectPath);
    }

    public Boolean checkPython(){

        boolean found = false;

        File[] fileList = getDir().listFiles();

        if(fileList != null){
            for (File file : fileList) {
                if (file.getName().endsWith((getExtension())))
                    found = true;

            }
        }
        else
            LOGGER.log(Level.INFO, "0 files found in " + getDir());

        return found;
    }

    public File getDir(){
        return this.projectDir;
    }

    public String getExtension(){
        return PYTHON_EXTENSION;
    }
}
