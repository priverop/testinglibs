package identify;

import java.io.File;

public class PythonIdentify {

    private static final String PYTHON_EXTENSION = ".py";
    private static File project_dir;

    public PythonIdentify(String project_path){
        project_dir = new File(project_path);
    }

    public Boolean checkPython(){

        boolean found = false;

        for (File file : getDir().listFiles()) {
            if (file.getName().endsWith((getExtension())))
                found = true;

        }
        return found;
    }

    public File getDir(){
        return this.project_dir;
    }

    public String getExtension(){
        return this.PYTHON_EXTENSION;
    }
}
