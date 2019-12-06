import java.util.Calendar;

public abstract class Ingredient {
    protected String name;
    protected Calendar manufacturingDate;
    protected int expireDays;

    public Ingredient() {}

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Name: " + this.name + "\n");
        output.append("Manufacturing Date: " + this.manufacturingDate + "\n");
        output.append("Expire Days: " + this.expireDays + "\n");
        return output.toString();
    }
}
