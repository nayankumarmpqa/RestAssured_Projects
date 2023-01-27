package files;

public class Payloads {
    public static String addPlacePayload(){
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";

    }

    public static String coursePriceComplexPayload() {

        return "{\n" +
                "\t\"dashboard\": {\n" +
                "\t\t\"purchaseAmount\": 910,\n" +
                "\t\t\"website\": \"rahulshettyacademy.com\"\n" +
                "\t},\n" +
                "\t\"courses\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"Selenium Python\",\n" +
                "\t\t\t\"price\": 50,\n" +
                "\t\t\t\"copies\": 6\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"Cypress\",\n" +
                "\t\t\t\"price\": 40,\n" +
                "\t\t\t\"copies\": 4\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"title\": \"RPA\",\n" +
                "\t\t\t\"price\": 45,\n" +
                "\t\t\t\"copies\": 10\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
    }


    public static String addBookPayload(){
        String addBookPayload = "{\n" +
                "\t\"name\": \"Learn Appium Automation with Java\",\n" +
                "\t\"isbn\": \"nk\",\n" +
                "\t\"aisle\": \"260102\",\n" +
                "\t\"author\": \"John foe\"\n" +
                "}";
        return addBookPayload;
    }


    public static String addBookPayload(String isbn, String aisle){
        String addBookPayload = "{\n" +
                "\t\"name\": \"Learn Appium Automation with Java\",\n" +
                "\t\"isbn\": \""+isbn+"\",\n" +
                "\t\"aisle\": \""+aisle+"\",\n" +
                "\t\"author\": \"John foe\"\n" +
                "}";
        return addBookPayload;
    }
}
