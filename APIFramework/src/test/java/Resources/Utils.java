package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;


    public RequestSpecification requestSpecification() throws IOException {

       if (requestSpecification ==null){
           PrintStream printStreamToLogFile = new PrintStream(new FileOutputStream("logFileOutputStream.txt"));

            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("baseUrl_PetStore"))
                    .setContentType(ContentType.JSON)
                    .setAccept(ContentType.JSON)
                    //Adding Request logs to a file
                    .addFilter(RequestLoggingFilter.logRequestTo(printStreamToLogFile))

                    //Adding Response logs to a file
                    .addFilter(ResponseLoggingFilter.logResponseTo(printStreamToLogFile))
                    .build();
            return requestSpecification;
       }
       return requestSpecification;
    }

    public ResponseSpecification responseSpecification() {
        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(3000L))
                .build();
        return responseSpecification;
    }

    public String getGlobalValue(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Hp\\Documents\\IntelliJ Projects\\APIFramework\\src\\test\\java\\Resources\\Global.Properties");
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }
}
