public class MilkTea {
    private String name;
    private Ingredient ingredient;

    public MilkTea(String name, Ingredient ingredient) {
        this.name = name;
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        return ("Name: " + this.name + "\n" + "Ingredient: \n" + this.ingredient
            + "\n");
    }
}
