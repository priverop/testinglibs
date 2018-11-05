package utilities;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResourceManager {

    private static final Logger LOGGER = Logger.getLogger( ResourceManager.class.getName() );

    public static String getResourcePath(String KeyFileName){
        File resource = null;
        try{
            resource = new File(ResourceManager.class.getClassLoader().getResource(KeyFileName).getFile());
        }
        catch (NullPointerException e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        finally {
            if(resource != null && resource.isDirectory())
                return resource.getPath();
            else if (resource != null) {
                return resource.getParent();
            }
            else{
                LOGGER.log(Level.SEVERE, "Can't find resource: " +KeyFileName);
            }
        }

        return null;

    }

}
