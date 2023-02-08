import files.Payloads;
import io.restassured.path.json.JsonPath;
import pojo.GetCourseResponsePojoClass;

public class Test {

    public static void main(String[] args) {
        JsonPath js = new JsonPath(Payloads.coursePriceComplexPayload());

        System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());


    }
}
