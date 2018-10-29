package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JSonManager {

    private static final Logger LOGGER = Logger.getLogger( JSonManager.class.getName() );

    public String readAndFind(File f, String w){

        JSONParser parser = new JSONParser();

        Object obj = new Object();

        try {
            obj = parser.parse(new FileReader(f.getAbsolutePath()));
        }
        catch (Exception e){
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }

        JSONObject jsonObject = (JSONObject) obj;

        return (String) jsonObject.get(w);


    }
}
