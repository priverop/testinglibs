package utilities;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class JSonManager {

    public String readAndFind(File f, String w){

        JSONParser parser = new JSONParser();

        Object obj = new Object();

        try {
            obj = parser.parse(new FileReader(f.getAbsolutePath()));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JSONObject jsonObject = (JSONObject) obj;

        return (String) jsonObject.get(w);


    }
}
