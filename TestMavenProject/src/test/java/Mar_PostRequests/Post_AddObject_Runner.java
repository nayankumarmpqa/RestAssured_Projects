package Mar_PostRequests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Post_AddObject_Runner {

    public static void main(String[] args) {
        AddObject_Pojo obj = new AddObject_Pojo();
        obj.setName("Nayan");
        Data d= new Data();
        d.setPrice(1000);
        d.setcPUModel("HP");
        d.setYear(2023);
        d.setHardDiskSize("1 TB");
        obj.setData(d);

        RestAssured.baseURI="https://api.restful-api.dev";
        given().
                log().all()
                .contentType(ContentType.JSON)
                .body(obj)
                .when().post("/objects")
                .then()
                .log().body()
                .contentType(ContentType.JSON)
                .assertThat().statusCode(200)
                .time(Matchers.lessThan(3000L))
                .body("data.year", equalTo(d.getYear()))
                .extract().response();
    }
}
