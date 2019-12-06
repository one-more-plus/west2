import java.util.Calendar;
import java.util.Date;

public class Bubble extends Ingredient {
    public Bubble() {
        this.name = "Bubble";
        this.expireDays = 7;
        this.manufacturingDate = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
