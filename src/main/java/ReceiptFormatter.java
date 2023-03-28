import java.util.List;

public class ReceiptFormatter {
    public String format(Receipt receipt) {
        StringBuilder receiptText = new StringBuilder();

        List<Item> items = receipt.getItems();
        for (Item item : items) {
            receiptText.append(item.toString()).append("\n");
        }

        receiptText.append("Sales Taxes: ").append(String.format("%.2f", receipt.getTotalTax())).append("\n");
        receiptText.append("Total: ").append(String.format("%.2f", receipt.getTotalPrice())).append("\n");

        return receiptText.toString();
    }
}
