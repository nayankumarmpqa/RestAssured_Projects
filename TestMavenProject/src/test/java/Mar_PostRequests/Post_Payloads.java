package Mar_PostRequests;

public class Post_Payloads {

    public static String AddAPetRequestBody(){
        return "{\n" +
                "  \"id\": 0,\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Hugo\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"pettagname\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
    }

    public static String myPostRequestBody(String title, String body){

        return "{\n" +
                "  \"title\": \""+title+"\",\n" +
                "  \"body\": \""+body+"\",\n" +
                "  \"userId\": \"1\" \n}";
    }
}
