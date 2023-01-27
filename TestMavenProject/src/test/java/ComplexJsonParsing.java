import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJsonParsing {

    public static void main(String[] args) {

        JsonPath js = new JsonPath(files.Payloads.coursePriceComplexPayload());

// fetching value of a field
        String s = js.get("dashboard.website");
        System.out.println(s);

        String s1 = js.get("courses.title[1]");
        System.out.println(s1);


//        1. Print No of courses returned by API
        System.out.println("-----------------------------1. Print No of courses returned by API");
        int coursesCount = js.getInt("courses.size()");
        System.out.println(coursesCount);

//2.Print Purchase Amount
        System.out.println("-----------------------------2.Print Purchase Amount");

        int pAmont = js.getInt("dashboard.purchaseAmount");
        System.out.println(pAmont);

        int pAmont2 = js.get("dashboard.purchaseAmount");
        System.out.println(pAmont2);

//3. Print Title of the first course
        System.out.println("-----------------------------3. Print Title of the first course");

        String tfc = js.get("courses[0].title");
        System.out.println(tfc);

        String tfc2 = js.get("courses[1].title");
        System.out.println(tfc2);

//4. Print All course titles and their respective Prices
        System.out.println("-----------------------------4. Print All course titles and their respective Prices");

        for (int i = 0; i < coursesCount; i++) {
            String titles = js.get("courses[" + i + "].title");
            System.out.println(titles);
        }

        System.out.println("-----------------OR-------------------");


        for (int i = 0; i < coursesCount; i++) {
            String titles = js.get("courses[" + i + "].title");
            String price = js.get("courses[" + i + "].price").toString();

            System.out.println(titles + " " + price);

        }
        System.out.println("-------------------OR-----------------");

        for (int i = 0; i < coursesCount; i++) {
            String titles = js.get("courses[" + i + "].title");
            int prices = js.getInt("courses[" + i + "].price");

            System.out.println(titles + " " + prices);
        }

//5. Print no of copies sold by RPA Course
        System.out.println("-----------------------------5. Print no of copies sold by RPA Course");

        for (int i = 0; i < coursesCount; i++) {
            String ct = js.get("courses[" + i + "].title");
            if (ct.equalsIgnoreCase("RPA")) {
                int noc = js.get("courses[" + i + "].copies");
                System.out.println(noc);
                break;
            }
        }


//6. Verify if Sum of all Course prices matches with Purchase Amount
        System.out.println("-----------------------------6. Verify if Sum of all Course prices matches with Purchase Amount");
        int sum = 0;
        for (int i = 0; i < coursesCount; i++) {

            int p = js.get("courses[" + i + "].price");
            int c = js.get("courses[" + i + "].copies");
            sum = sum + (p * c);

           }
        System.out.println("Actual Purchase amount is = "+js.get("dashboard.purchaseAmount"));
        System.out.println("Calculated Purchase amount is = " + sum);
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        Assert.assertEquals(sum,purchaseAmount);
    }
}
