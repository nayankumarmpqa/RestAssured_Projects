package PayloadFiles;

public class AddPlacePayload {

    public static String addPlacePayloadString () {

        return "{\n" +
                "\t\"location\": {\n" +
                "\t\t\"lat\": -38.383494,\n" +
                "\t\t\"lng\": 33.427362\n" +
                "\t},\n" +
                "\t\"accuracy\": 150,\n" +
                "\t\"name\": \"Frontline house1\",\n" +
                "\t\"phone_number\": \"(+91) 983 893 3937\",\n" +
                "\t\"address\": \"29, side layout, cohen 09\",\n" +
                "\t\"types\": [\n" +
                "\t\t\"shoe park\",\n" +
                "\t\t\"shop\"\n" +
                "\t],\n" +
                "\t\"website\": \"http://google.com\",\n" +
                "\t\"language\": \"French-IN\"\n" +
                "}";
    }



    public static String updatePlacePayloadString () {

        return "{\n" +
                "\"place_id\":\"8d2573bdf6ceec0e474c5f388fa917fb\",\n" +
                "\"address\":\"70 Summer walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
    }

    public static class ReusableMethods {
    }
}
