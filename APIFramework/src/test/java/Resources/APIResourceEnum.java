package Resources;

public enum APIResourceEnum {
    AddPetAPI("/pet");

    private String APIResourceEnumName;

        APIResourceEnum(String APIResourceEnumName){
            this.APIResourceEnumName = APIResourceEnumName;
        }

        public String getAPIResourceName(){
            return APIResourceEnumName;
        }
}
