package identify;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;

public abstract class AbstractIdentify {

    protected static File keyFile;
    protected static String KEYFILENAME;

    public AbstractIdentify(String project_path, String keyFileName){
        KEYFILENAME = keyFileName;
        keyFile = new File(project_path + KEYFILENAME);
    }

    public File getKeyFile(){
        return keyFile;
    }

    public Boolean checkKeyFile(){
        return getKeyFile().exists() && !getKeyFile().isDirectory();
    }

}
