import java.util.Calendar;

public class Coconut extends Ingredient{
    public Coconut() {
        this.name = "Coconut";
        this.expireDays = 5;
        this.manufacturingDate = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
