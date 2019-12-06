import exceptions.SoldOutException;

public interface Shop {
    public void addIngredient(Ingredient ingredient);

    public void sellMilkTea(String milkTeaName, String ingredientName) throws
            SoldOutException;

    public void addStock(Coconut coconut);
}
