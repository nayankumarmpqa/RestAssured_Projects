package AbstractionConcepts;

public class RecipeRunner {
    public static void main(String[] args) {
        CurryRecipe curryRecipe = new CurryRecipe();
        curryRecipe.executeRecipe();
        curryRecipe.curryRecipe2();
        System.out.println("---------------------------");
        AbstractRecipe abstractRecipe = new CurryRecipe();
        abstractRecipe.executeRecipe();
        //abstractRecipe.curryRecipe2(); not allowed due to parent class reference with child class object case

//Another implementation class for abstract class
        MicrowaveCurryRecipe microwaveRecipe = new MicrowaveCurryRecipe();
        microwaveRecipe.executeRecipe();
//MicrowaveCurryRecipe defines what needs to be done in each step.
// When we invoke the executeRecipe method, the steps are executed in order.

        /*
        Summary
            This pattern is called a Template method pattern.
            You define an abstract class with the order of steps defined.
            You leave the implementation of each of the steps to the sub classes.
         */

    }


}
