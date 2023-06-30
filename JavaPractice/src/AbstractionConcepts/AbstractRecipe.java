package AbstractionConcepts;

abstract public class AbstractRecipe {
    //We defined abstract methods for each of the steps
    // and created an execute method calling them.
    // execute method ensures that the order of method call is followed.
    public void executeRecipe() {
        prepareInputs();
        cookRecipe();
        cleanup();
    }

    // prepare
    // recipe
    // cleanup
    // abstract methods
    abstract void prepareInputs();
    abstract void cookRecipe();
    abstract void cleanup();


}
