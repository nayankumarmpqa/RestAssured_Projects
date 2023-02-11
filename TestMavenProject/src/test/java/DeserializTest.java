import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import pojo.GetCourseResponsePojoClass;

import static io.restassured.RestAssured.*;

public class DeserializTest {

    public static void main(String[] args) {
        RestAssured.baseURI = "";
        GetCourseResponsePojoClass gc = given().queryParam("", "").expect().defaultParser(Parser.JSON)
                .when()
                .get("").as(GetCourseResponsePojoClass.class);

        String s = gc.getCourses().getWebAutomation().get(1).getCourseTitle();

        String gi=gc.getInstructor();
        String exp=gc.getExpertise();


    }
}
