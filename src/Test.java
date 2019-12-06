import exceptions.SoldOutException;

import java.util.Calendar;

public class Test {
    public static void main(String[] args) throws SoldOutException {
        Calendar now = Calendar.getInstance();
        Calendar totallyExpiredDate = Calendar.getInstance();
        totallyExpiredDate.set(1990, Calendar.JANUARY, 1);

        Coconut expiredCoconut = new Coconut();
        expiredCoconut.manufacturingDate = totallyExpiredDate;
        Bubble expiredBubble = new Bubble();
        expiredBubble.manufacturingDate = totallyExpiredDate;

        Coconut normalCoconut = new Coconut();
        Bubble normalBubble = new Bubble();

        MilkTea bubbleTea = new MilkTea("Bubble Milktea", normalBubble);
        MilkTea coconutTea = new MilkTea("Coconut Milktea", normalCoconut);
        System.out.println(bubbleTea);
        System.out.println(coconutTea);

        TeaShop teaShop = new TeaShop();
        teaShop.addIngredient(normalBubble);
        teaShop.addIngredient(expiredBubble);
        teaShop.addIngredient(expiredBubble);
        teaShop.addIngredient(normalBubble);

        System.out.println(teaShop.bubbleList.size() + " <-- this should be 4\n");

        teaShop.sellMilkTea("Bubble Milktea", "Bubble");
        System.out.println(teaShop.bubbleList.size() + " <-- this should be 3\n");

        teaShop.sellMilkTea("Bubble Milktea", "Bubble");
        System.out.println(teaShop.bubbleList.size() + " <-- this should be 0\n");

        teaShop.sellMilkTea("Bubble Milktea", "Bubble");
        System.out.println("^^ this should print sold out message ^^\n");

        teaShop.addIngredient(normalCoconut);
        teaShop.addIngredient(expiredCoconut);
        teaShop.addIngredient(expiredCoconut);
        teaShop.addIngredient(expiredCoconut);
        teaShop.addIngredient(normalCoconut);

        System.out.println(teaShop.coconutsList.size() + " <-- this should be 5\n");

        teaShop.sellMilkTea("Coconut Milktea", "Coconut");
        System.out.println(teaShop.coconutsList.size() + " <-- this should be 4\n");

        teaShop.sellMilkTea("Coconut Milktea", "Coconut");
        System.out.println(teaShop.coconutsList.size() + " <-- this should be 0\n");

        teaShop.sellMilkTea("Coconut Milktea", "Coconut");
        System.out.println("^^ this should print sold out message ^^\n");
    }
}
