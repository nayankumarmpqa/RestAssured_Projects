package AbstractionConcepts;

public class MicrowaveCurryRecipe extends AbstractRecipe {
    //constructor
    public MicrowaveCurryRecipe() {
        System.out.println("[Curry Microwave Method]");
    }
    @Override
    void prepareInputs() {
        System.out.println("Get Vegetables Cut and Ready");
        System.out.println("Switch on Microwave");
    }
    @Override
    void cookRecipe() {
        System.out.println("Microwave Vegetables");
        System.out.println("Add Seasoning");
    }
    @Override
    void cleanup() {
        System.out.println("Switch Off Microwave");
        System.out.println("Discard unused Vegetables");
    }
}