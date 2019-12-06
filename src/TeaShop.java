import exceptions.SoldOutException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TeaShop implements Shop{
    protected List<Coconut> coconutsList = new ArrayList<>();
    protected List<Bubble> bubbleList = new ArrayList<>();

    public TeaShop() {

    }

    public void addIngredient(Ingredient ingredient) {
        if (ingredient instanceof Bubble) {
            addStock((Bubble)ingredient);
        } else if (ingredient instanceof Coconut) {
            addStock((Coconut)ingredient);
        }
    }

    public void sellMilkTea(String milkTeaName, String ingredientName) throws
            SoldOutException {
        Calendar now = Calendar.getInstance();
        if (ingredientName.equals("Bubble")) {
             while(true) {
                 if (bubbleList.size() == 0) {
                     try {
                         throw new SoldOutException();
                     } catch (SoldOutException e) {
                         System.out.println("Bubble has been sold out!");
                         return;
                     }
                 }
                 Calendar expireDate = bubbleList.get(0).manufacturingDate;
                 expireDate.add(Calendar.DATE, 7);
                 if (now.before(expireDate)) {          //not expire
                    bubbleList.remove(0);
                    break;
                 } else {                               //expire;
                     bubbleList.remove(0);
                 }
            }
        } else if (ingredientName.equals("Coconut")) {
            while(true) {
                if (coconutsList.size() == 0) {
                    try {
                        throw new SoldOutException();
                    } catch (SoldOutException e) {
                        System.out.println("Coconut has been sold out!");
                        return;
                    }
                }
                Calendar expireDate = coconutsList.get(0).manufacturingDate;
                expireDate.add(Calendar.DATE, 5);
                if (now.before(expireDate)) {          //not expire
                    coconutsList.remove(0);
                    break;
                } else {                               //expire;
                    coconutsList.remove(0);
                }
            }
        }
    }

    public void addStock(Coconut coconut) {
        this.coconutsList.add(coconut);
    }

    public void addStock(Bubble bubble) {
        this.bubbleList.add(bubble);
    }
}
