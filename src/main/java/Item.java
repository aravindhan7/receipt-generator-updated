public class Item {
    private int quantity;
    private String name;
    private double price;
    private boolean isImported;
    private boolean isExempted;

    public Item(int quantity, String name, double price, boolean isImported, boolean isExempted) {
        this.quantity = quantity;
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempted = isExempted;
    }

    public double getTax() {
        double tax = 0.0;
        if (!isExempted) {
            tax += 0.1 * price;
        }
        if (isImported) {
            tax += 0.05 * price;
        }
        return tax;
    }

    public double getPriceWithTax() {
        return price + getTax();
    }

    @Override
    public String toString() {
        String imported = isImported ? "imported " : "";
        return quantity + " " + imported + name + ": " + String.format("%.2f", getPriceWithTax());
    }
}