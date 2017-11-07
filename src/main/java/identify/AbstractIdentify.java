package identify;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.File;

public abstract class AbstractIdentify {

    protected static File keyFile;
    protected static String KEYFILENAME;
    private static String ARTIFACTID;

    public AbstractIdentify(String project_path, String keyFileName, String artifactID){
        ARTIFACTID = artifactID;
        KEYFILENAME = keyFileName;
        keyFile = new File(project_path + KEYFILENAME);
    }

    public File getKeyFile(){
        return keyFile;
    }

    public String getFramework(){
        return ARTIFACTID;
    }

    public Boolean checkKeyFile(){
        return getKeyFile().exists() && !getKeyFile().isDirectory();
    }

    public abstract Boolean checkFramework();
}
