package Resources;

public enum APIResourceEnum {
    AddPetAPI(""),
    GetPetByIdAPI(""),
    DeletePetAPI("");
    private String APIResourceEnumName;


    APIResourceEnum(String aPIResourceEnumNameFromStepDefMethod) {
        this.APIResourceEnumName = aPIResourceEnumNameFromStepDefMethod;
        // above line will match,pick valueOf api field above
        // and assign the aPIResourceEnumNameFromStepDefMethod with fields defined in this class for aPIResourceEnumName
    }

    public String getAPIResourceName() {
        return APIResourceEnumName;
    }
}
