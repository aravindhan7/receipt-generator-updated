import java.util.List;

public class Receipt {
    private List<Item> items;
    private double totalPrice;
    private double totalTax;

    public Receipt(List<Item> items) {
        this.items = items;
        calculateTotals();
    }

    private void calculateTotals() {
        for (Item item : items) {
            this.totalTax += item.getTax();
            this.totalPrice += item.getPriceWithTax();
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalTax() {
        return totalTax;
    }
}
