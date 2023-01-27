package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

    public static JsonPath responseStringToJsonObj(String resposeVariable){

        JsonPath js = new JsonPath(resposeVariable);
    return js;
    }
}
