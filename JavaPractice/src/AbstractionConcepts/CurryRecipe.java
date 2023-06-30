package AbstractionConcepts;

public class CurryRecipe extends AbstractRecipe{

    @Override
    void prepareInputs() {
        System.out.println("* Get Vegetables Cut and Ready");
        System.out.println("* Get Spices Ready");

    }

    @Override
    void cookRecipe() {
        System.out.println(">> Steam And Fry Vegetables");
        System.out.println(">> Cook With Spices");
        System.out.println(">> Add Seasoning");
    }

    @Override
    void cleanup() {
        System.out.println("--> Discard unused Vegetables");
        System.out.println("--> Discard unused Spices");
    }

    // created one constructor to see which recipe is running
    public CurryRecipe() {
        System.out.println("[Curry Preparation Method]");
    }
}
