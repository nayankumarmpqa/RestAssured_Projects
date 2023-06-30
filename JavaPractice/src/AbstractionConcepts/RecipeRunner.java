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


    }


}
