package PayloadFilesPackage;

public class PlacePayloads {

    public static String AddPlacePayload(){
        return "{\n" +
                "\t\"location\": {\n" +
                "\t\t\"lat\": -38.383494,\n" +
                "\t\t\"lng\": 33.427362\n" +
                "\t},\n" +
                "\t\"accuracy\": 150,\n" +
                "\t\"name\": \"NK Aug 24\",\n" +
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

    public static String UpdatePlacePayload(String place_Id, String newAddress) {
        return "{\n" +
                "\"place_id\":\""+place_Id+"\",\n" +
                "\"address\":\""+newAddress+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}";
    }
}
