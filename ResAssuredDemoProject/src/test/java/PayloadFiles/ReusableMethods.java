package PayloadFiles;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

    public static JsonPath responseStringToJsonObj(String responsefromAPI){
        JsonPath js = new JsonPath(responsefromAPI);
        return js;
    }
}
